package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository resultRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository holdingRepository;
    private final RiskThresholdRepository thresholdRepository;

    // 🚨 Constructor order MUST match spec
    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository resultRepository,
            UserPortfolioRepository portfolioRepository,
            PortfolioHoldingRepository holdingRepository,
            RiskThresholdRepository thresholdRepository) {

        this.resultRepository = resultRepository;
        this.portfolioRepository = portfolioRepository;
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        RiskThreshold threshold = thresholdRepository.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("Not found"));

        List<PortfolioHolding> holdings =
                holdingRepository.findByPortfolioId(portfolioId);

        double totalValue = holdings.stream()
                .map(h -> h.getMarketValue().doubleValue())
                .reduce(0.0, Double::sum);

        double maxStockPct = 0.0;

        if (totalValue > 0) {
            for (PortfolioHolding h : holdings) {
                double pct = (h.getMarketValue().doubleValue() / totalValue) * 100;
                if (pct > maxStockPct) {
                    maxStockPct = pct;
                }
            }
        }

        boolean highRisk =
                maxStockPct > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        result.setHighestStockPercentage(maxStockPct);
        result.setHighestSectorPercentage(maxStockPct); // simplified
        result.setIsHighRisk(highRisk);
        result.setNotes(highRisk ? "High concentration risk" : "Within limits");

        return resultRepository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return resultRepository.findByPortfolioId(portfolioId);
    }
}

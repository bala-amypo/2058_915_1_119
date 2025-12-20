package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final PortfolioHoldingRepository holdingRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final RiskThresholdRepository thresholdRepository;
    private final RiskAnalysisResultRepository analysisRepository;

    public RiskAnalysisServiceImpl(PortfolioHoldingRepository holdingRepository,
                                   UserPortfolioRepository portfolioRepository,
                                   RiskThresholdRepository thresholdRepository,
                                   RiskAnalysisResultRepository analysisRepository) {
        this.holdingRepository = holdingRepository;
        this.portfolioRepository = portfolioRepository;
        this.thresholdRepository = thresholdRepository;
        this.analysisRepository = analysisRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        List<PortfolioHolding> holdings = holdingRepository.findByPortfolioId(portfolioId);

        BigDecimal totalValue = holdings.stream()
                .map(PortfolioHolding::getMarketValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        double highestPercentage = 0.0;

        for (PortfolioHolding h : holdings) {
            double pct = h.getMarketValue()
                    .divide(totalValue, 4, BigDecimal.ROUND_HALF_UP)
                    .doubleValue() * 100;
            highestPercentage = Math.max(highestPercentage, pct);
        }

        RiskThreshold threshold = thresholdRepository.findByPortfolioId(portfolioId)
                .orElse(null);

        boolean isHighRisk = threshold != null &&
                highestPercentage > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult(
                portfolio,
                LocalDateTime.now(),
                highestPercentage,
                isHighRisk
        );

        return analysisRepository.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepository.findByPortfolioId(portfolioId);
    }
}

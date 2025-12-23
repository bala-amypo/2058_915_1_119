package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.UserPortfolio;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final UserPortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository holdingRepository;
    private final RiskThresholdRepository thresholdRepository;
    private final RiskAnalysisResultRepository resultRepository;

    public RiskAnalysisServiceImpl(UserPortfolioRepository portfolioRepository,
                                   PortfolioHoldingRepository holdingRepository,
                                   RiskThresholdRepository thresholdRepository,
                                   RiskAnalysisResultRepository resultRepository) {
        this.portfolioRepository = portfolioRepository;
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        List<PortfolioHolding> holdings = holdingRepository.findByPortfolioId(portfolioId);
        RiskThreshold threshold = thresholdRepository.findByPortfolioId(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));

        double totalValue = holdings.stream()
                .mapToDouble(h -> h.getMarketValue().doubleValue())
                .sum();

        double highestPercent = holdings.stream()
                .mapToDouble(h -> h.getMarketValue().doubleValue() / totalValue * 100)
                .max().orElse(0);

        boolean isHighRisk = highestPercent > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(LocalDateTime.now());
        result.setHighestStockPercentage(highestPercent);
        result.setIsHighRisk(isHighRisk);

        return resultRepository.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return resultRepository.findByPortfolioId(portfolioId);
    }
}

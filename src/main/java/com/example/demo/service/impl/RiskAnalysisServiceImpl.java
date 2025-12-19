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
    private final RiskThresholdRepository thresholdRepository;
    private final RiskAnalysisResultRepository analysisRepository;
    private final UserPortfolioRepository portfolioRepository;

    public RiskAnalysisServiceImpl(
            PortfolioHoldingRepository holdingRepository,
            RiskThresholdRepository thresholdRepository,
            RiskAnalysisResultRepository analysisRepository,
            UserPortfolioRepository portfolioRepository) {
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
        this.analysisRepository = analysisRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Portfolio not found"));

        List<PortfolioHolding> holdings =
                holdingRepository.findByPortfolioId(portfolioId);

        BigDecimal totalValue = holdings.stream()
                .map(PortfolioHolding::getMarketValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        double highestPercentage = holdings.stream()
                .mapToDouble(h ->
                        h.getMarketValue()
                                .divide(totalValue, 4,
                                        BigDecimal.ROUND_HALF_UP)
                                .doubleValue() * 100)
                .max()
                .orElse(0);

        RiskThreshold threshold = thresholdRepository.findAll()
                .stream()
                .filter(t -> t.getPortfolio().getId().equals(portfolioId))
                .findFirst()
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

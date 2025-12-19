package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;

    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository holdingRepository,
            UserPortfolioRepository portfolioRepository,
            StockRepository stockRepository) {
        this.holdingRepository = holdingRepository;
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public PortfolioHolding addHolding(Long portfolioId, Long stockId,
                                       PortfolioHolding holding) {

        if (holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (holding.getMarketValue().signum() < 0) {
            throw new IllegalArgumentException("Market value must be non-negative");
        }

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Portfolio not found"));

        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Stock not found"));

        holding.setPortfolio(portfolio);
        holding.setStock(stock);
        return holdingRepository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }
}

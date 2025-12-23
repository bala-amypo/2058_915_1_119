package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) { return List.of(); }
}
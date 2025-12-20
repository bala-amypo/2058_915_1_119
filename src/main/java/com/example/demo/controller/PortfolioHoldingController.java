package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping("/{portfolioId}/{stockId}")
    public ApiResponse<PortfolioHolding> addHolding(
            @PathVariable Long portfolioId,
            @PathVariable Long stockId,
            @RequestBody PortfolioHolding holding) {

        return new ApiResponse<>(true, "Holding added",
                holdingService.addHolding(portfolioId, stockId, holding));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ApiResponse<List<PortfolioHolding>> getHoldings(
            @PathVariable Long portfolioId) {

        return new ApiResponse<>(true, "Portfolio holdings",
                holdingService.getHoldingsByPortfolio(portfolioId));
    }
}

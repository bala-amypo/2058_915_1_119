package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping("/{portfolioId}")
    public ApiResponse<RiskThreshold> setThreshold(
            @PathVariable Long portfolioId,
            @RequestBody RiskThreshold threshold) {

        return new ApiResponse<>(true, "Risk threshold saved",
                thresholdService.setThreshold(portfolioId, threshold));
    }

    @GetMapping("/{portfolioId}")
    public ApiResponse<RiskThreshold> getThreshold(
            @PathVariable Long portfolioId) {

        return new ApiResponse<>(true, "Risk threshold fetched",
                thresholdService.getThresholdForPortfolio(portfolioId));
    }
}

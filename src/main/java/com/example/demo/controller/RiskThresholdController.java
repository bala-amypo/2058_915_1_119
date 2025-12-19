package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    @Autowired
    private RiskThresholdService thresholdService;

    @PostMapping("/{portfolioId}")
    public RiskThreshold setThreshold(
            @PathVariable Long portfolioId,
            @RequestBody RiskThreshold threshold) {

        return thresholdService.setThreshold(portfolioId, threshold);
    }

    @GetMapping("/{portfolioId}")
    public RiskThreshold getThreshold(@PathVariable Long portfolioId) {
        return thresholdService.getThresholdForPortfolio(portfolioId);
    }
}

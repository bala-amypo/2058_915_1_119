package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService riskAnalysisService;

    public RiskAnalysisController(RiskAnalysisService riskAnalysisService) {
        this.riskAnalysisService = riskAnalysisService;
    }

    @PostMapping("/{portfolioId}")
    public ApiResponse<RiskAnalysisResult> analyze(
            @PathVariable Long portfolioId) {

        return new ApiResponse<>(true, "Risk analysis completed",
                riskAnalysisService.analyzePortfolio(portfolioId));
    }

    @GetMapping("/{portfolioId}")
    public ApiResponse<List<RiskAnalysisResult>> getAnalyses(
            @PathVariable Long portfolioId) {

        return new ApiResponse<>(true, "Risk analysis history",
                riskAnalysisService.getAnalysesForPortfolio(portfolioId));
    }
}

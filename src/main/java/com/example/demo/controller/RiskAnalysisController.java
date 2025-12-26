package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.RiskAnalysisResult;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {
    @PostMapping("/analyze/{portfolioId}")
public RiskAnalysisResult analyze(@PathVariable Long portfolioId)
    @GetMapping("/{id}")
public RiskAnalysisResult getById(@PathVariable Long id)
    @GetMapping("/portfolio/{portfolioId}")
public List<RiskAnalysisResult> getByPortfolio(@PathVariable Long portfolioId)
}
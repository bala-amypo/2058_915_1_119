package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.RiskAnalysisResult;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {
    
    @PostMapping("/{portfolioId}")
    public ResponseEntity<RiskAnalysisResult> createAnalysis(
            @PathVariable Long portfolioId,
            @RequestBody RiskAnalysisResult analysis) {
        return ResponseEntity.ok(analysis);
    }
    
    @GetMapping("/{portfolioId}")
    public ResponseEntity<RiskAnalysisResult> getAnalysis(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(new RiskAnalysisResult());
    }
}
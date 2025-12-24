package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.RiskThreshold;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {
    
    @PostMapping("/{portfolioId}")
    public ResponseEntity<RiskThreshold> createThreshold(
            @PathVariable Long portfolioId,
            @RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(threshold);
    }
    
    @GetMapping("/{portfolioId}")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(new RiskThreshold());
    }
}
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.PortfolioHolding;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {
    
    @PostMapping("/{portfolioId}/{stockId}")
    public ResponseEntity<PortfolioHolding> createHolding(
            @PathVariable Long portfolioId, 
            @PathVariable Long stockId,
            @RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holding);
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(List.of());
    }
}
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.PortfolioHolding;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {
    
    @PostMapping
public PortfolioHolding create(@RequestBody PortfolioHolding holding)
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(List.of());
    }
}
package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
@Tag(name = "Portfolio Management", description = "Portfolio operations")
public class UserPortfolioController {
    
    @Autowired(required = false)
    private UserPortfolioService portfolioService;
    
    @PostMapping
    @Operation(summary = "Create portfolio")
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        if (portfolioService != null) {
            return ResponseEntity.ok(portfolioService.createPortfolio(portfolio));
        }
        return ResponseEntity.ok(portfolio);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get portfolio by ID")
    public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable Long id) {
        if (portfolioService != null) {
            return ResponseEntity.ok(portfolioService.getPortfolioById(id));
        }
        return ResponseEntity.ok(new UserPortfolio());
    }
}
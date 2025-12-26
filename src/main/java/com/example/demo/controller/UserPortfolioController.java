package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {
    @Autowired
    private UserPortfolioService portfolioService;
    
    @PostMapping
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.createPortfolio(portfolio));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable Long id) {
        return ResponseEntity.ok(portfolioService.getPortfolioById(id));
    }
    @GetMapping("/user/{userId}")
public ResponseEntity<?> getPortfoliosByUser(@PathVariable Long userId) {
    return ResponseEntity.ok(userPortfolioService.getPortfoliosByUser(userId));
}
    @PutMapping("/{id}/deactivate")
public ResponseEntity<?> deactivatePortfolio(@PathVariable Long id) {
    userPortfolioService.deactivatePortfolio(id);
    return ResponseEntity.ok("Portfolio deactivated");
}
}
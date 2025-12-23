package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserPortfolioController {
    @Autowired
    private UserPortfolioService portfolioService;
    
    public ResponseEntity<UserPortfolio> createPortfolio(UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.createPortfolio(portfolio));
    }
    
    public ResponseEntity<UserPortfolio> getPortfolio(Long id) {
        return ResponseEntity.ok(portfolioService.getPortfolioById(id));
    }
}
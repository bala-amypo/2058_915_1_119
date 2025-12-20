package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService portfolioService;

    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping
    public ApiResponse<UserPortfolio> createPortfolio(
            @RequestBody UserPortfolio portfolio) {

        return new ApiResponse<>(true, "Portfolio created",
                portfolioService.createPortfolio(portfolio));
    }

    @GetMapping("/{id}")
    public ApiResponse<UserPortfolio> getPortfolio(@PathVariable Long id) {
        return new ApiResponse<>(true, "Portfolio fetched",
                portfolioService.getPortfolioById(id));
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<UserPortfolio>> getPortfoliosByUser(
            @PathVariable Long userId) {

        return new ApiResponse<>(true, "User portfolios",
                portfolioService.getPortfoliosByUser(userId));
    }
}

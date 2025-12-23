package com.example.demo.model;

public class UserPortfolio {
    private Long id;
    private String portfolioName;
    private Long userId;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
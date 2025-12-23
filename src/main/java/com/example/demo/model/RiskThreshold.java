package com.example.demo.model;

public class RiskThreshold {
    private Long id;
    private Double maxSingleStockPercentage;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Double getMaxSingleStockPercentage() { return maxSingleStockPercentage; }
    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) { 
        this.maxSingleStockPercentage = maxSingleStockPercentage; 
    }
}
package com.example.demo.model;

import java.sql.Timestamp;

public class RiskAnalysisResult {
    private Long id;
    private Double highestStockPercentage;
    private boolean highRisk;
    private Timestamp analysisDate;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Double getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(Double highestStockPercentage) { 
        this.highestStockPercentage = highestStockPercentage; 
    }
    
    public boolean isHighRisk() { return highRisk; }
    public void setHighRisk(boolean highRisk) { this.highRisk = highRisk; }
    
    public Timestamp getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(Timestamp analysisDate) { this.analysisDate = analysisDate; }
}
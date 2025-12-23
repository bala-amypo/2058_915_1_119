package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_thresholds")
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long portfolioId;

    private Double maxSingleStockPercentage;

    private Double maxOverallVolatility;

    public RiskThreshold() {
    }

    public RiskThreshold(Long portfolioId,
                         Double maxSingleStockPercentage,
                         Double maxOverallVolatility) {
        this.portfolioId = portfolioId;
        this.maxSingleStockPercentage = maxSingleStockPercentage;
        this.maxOverallVolatility = maxOverallVolatility;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }
    
    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Double getMaxSingleStockPercentage() {
        return maxSingleStockPercentage;
    }
    
    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) {
        this.maxSingleStockPercentage = maxSingleStockPercentage;
    }

    public Double getMaxOverallVolatility() {
        return maxOverallVolatility;
    }
    
    public void setMaxOverallVolatility(Double maxOverallVolatility) {
        this.maxOverallVolatility = maxOverallVolatility;
    }
}

package com.example.demo.repository;

import com.example.demo.model.RiskAnalysisResult;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RiskAnalysisResultRepository {
    RiskAnalysisResult save(RiskAnalysisResult result);
    RiskAnalysisResult findById(Long id);
    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);
}
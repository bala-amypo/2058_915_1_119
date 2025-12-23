package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) { return List.of(); }
}
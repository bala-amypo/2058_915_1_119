package com.example.demo.controller;

import com.example.demo.service.RiskThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {
    
    @Autowired
    private RiskThresholdService thresholdService;
}
package com.example.demo.service.impl;

import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {
    @Override
public List<RiskThreshold> getAllThresholds() {
    return repository.findAll();
}

}
package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return repository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = repository.findById(id);
        if (existing == null) {
            throw new RuntimeException("Not found");
        }
        threshold.setId(id);
        return repository.save(threshold);
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return repository.findByActiveTrue();
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        RiskThreshold threshold = repository.findById(id);
        if (threshold == null) {
            throw new RuntimeException("Not found");
        }
        return threshold;
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return repository.findAll();
    }
}

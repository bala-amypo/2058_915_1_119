package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.RiskThreshold;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {
    @PostMapping
public RiskThreshold create(@RequestBody RiskThreshold threshold)
    @PutMapping("/{id}")
public RiskThreshold update(@PathVariable Long id, @RequestBody RiskThreshold threshold)
    @GetMapping("/active")
public RiskThreshold getActive()
    @GetMapping("/{id}")
public RiskThreshold getById(@PathVariable Long id)
    @GetMapping
public List<RiskThreshold> getAll()
}
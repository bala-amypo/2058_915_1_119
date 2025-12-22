package com.example.demo.service.impl;

import com.example.demo.dto.RiskThresholdRequest;
import com.example.demo.dto.RiskThresholdResponse;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    @Override
    public RiskThresholdResponse evaluateRisk(RiskThresholdRequest request) {

        RiskThresholdResponse response = new RiskThresholdResponse();

        if (request == null || request.getPortfolio() == null) {
            response.setHighRisk(false);
            response.setMessage("Invalid request");
            return response;
        }

        boolean isHighRisk =
                request.getMaxSingleStockPercentage() > 50 ||
                request.getMaxOverallVolatility() > 30;

        response.setHighRisk(isHighRisk);
        response.setMessage(
                isHighRisk ? "High risk portfolio" : "Safe portfolio"
        );

        return response;
    }
}

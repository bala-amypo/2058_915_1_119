package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@Tag(name = "portfolio-holding-controller")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping
    public ResponseEntity<PortfolioHolding> create(@RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.createHolding(holding));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioHolding> update(
            @PathVariable Long id,
            @RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.updateHolding(id, holding));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioHolding> getById(@PathVariable Long id) {
        return ResponseEntity.ok(holdingService.getHoldingById(id));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getByPortfolio(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(holdingService.getHoldingsByPortfolio(portfolioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        holdingService.deleteHolding(id);
        return ResponseEntity.ok("Holding deleted");
    }
}

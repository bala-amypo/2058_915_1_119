package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@AutoConfigureMockMvc(addFilters = false)

public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ApiResponse<Stock> createStock(@RequestBody Stock stock) {
        return new ApiResponse<>(true, "Stock created",
                stockService.createStock(stock));
    }

    @PutMapping("/{id}")
    public ApiResponse<Stock> updateStock(@PathVariable Long id,
                                          @RequestBody Stock stock) {
        return new ApiResponse<>(true, "Stock updated",
                stockService.updateStock(id, stock));
    }

    @GetMapping("/{id}")
    public ApiResponse<Stock> getStock(@PathVariable Long id) {
        return new ApiResponse<>(true, "Stock fetched",
                stockService.getStockById(id));
    }

    @GetMapping
    public ApiResponse<List<Stock>> getAllStocks() {
        return new ApiResponse<>(true, "All stocks",
                stockService.getAllStocks());
    }

    @PatchMapping("/{id}/deactivate")
    public ApiResponse<Void> deactivateStock(@PathVariable Long id) {
        stockService.deactivateStock(id);
        return new ApiResponse<>(true, "Stock deactivated", null);
    }
}

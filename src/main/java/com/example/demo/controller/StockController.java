package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;
    
    public ResponseEntity<Stock> createStock(Stock stock) {
        return ResponseEntity.ok(stockService.createStock(stock));
    }
    
    public ResponseEntity<Stock> updateStock(Long id, Stock stock) {
        return ResponseEntity.ok(stockService.updateStock(id, stock));
    }
    
    public ResponseEntity<Stock> getStock(Long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }
    
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }
    
    public ResponseEntity<Void> deactivateStock(Long id) {
        stockService.deactivateStock(id);
        return ResponseEntity.ok().build();
    }
}
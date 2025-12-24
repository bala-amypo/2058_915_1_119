package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    public Stock createStock(Stock stock) { return stock; }
    public Stock updateStock(Long id, Stock stock) { return stock; }
    public Stock getStockById(Long id) { return new Stock(); }
    public List<Stock> getAllStocks() { return List.of(); }
    public void deactivateStock(Long id) {}
}
package com.example.demo.repository;

import com.example.demo.model.Stock;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StockRepository {
    Stock save(Stock stock);
    Stock findById(Long id);
    List<Stock> findAll();
    void deleteById(Long id);
}
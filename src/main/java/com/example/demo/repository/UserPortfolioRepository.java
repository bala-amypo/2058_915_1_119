package com.example.demo.repository;

import com.example.demo.model.UserPortfolio;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserPortfolioRepository {
    UserPortfolio save(UserPortfolio portfolio);
    UserPortfolio findById(Long id);
    List<UserPortfolio> findByUserId(Long userId);
}
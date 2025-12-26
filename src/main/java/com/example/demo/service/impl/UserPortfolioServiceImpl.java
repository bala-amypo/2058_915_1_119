package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {
    public UserPortfolio createPortfolio(UserPortfolio portfolio) { return portfolio; }
    public UserPortfolio getPortfolioById(Long id) { return new UserPortfolio(); }
    public List<UserPortfolio> getPortfoliosByUser(Long userId) { return List.of(); }
    @Override
public void deactivatePortfolio(Long id) {
    UserPortfolio portfolio = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    portfolio.setActive(false);
    repository.save(portfolio);
}

}
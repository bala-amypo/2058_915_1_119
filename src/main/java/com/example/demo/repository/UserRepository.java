package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User save(User user);
    User findById(Long id);
    User findByEmail(String email);
}
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        AuthResponse response = new AuthResponse();
        response.setUserId(1L);
        response.setEmail(request.getEmail());
        response.setRole("ADMIN");
        response.setToken("dummy-token");
        return response;
    }
}

package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody LoginRequest request) {

        // Dummy authentication logic (no security)
        User user = userService.findByEmail(request.getEmail());

        AuthResponse response = new AuthResponse(
                "DUMMY_TOKEN",
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new ApiResponse<>(true, "Login successful (No Security Mode)", response);
    }
}

package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET = "secretkey";

    public String generateToken(String email, String role, Long userId) {
        return Jwts.builder()
                .claim("email", email)
                .claim("role", role)
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
    }
}

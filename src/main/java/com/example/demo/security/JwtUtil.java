package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email) {
        return "DUMMY-TOKEN-FOR-" + email;
    }
}

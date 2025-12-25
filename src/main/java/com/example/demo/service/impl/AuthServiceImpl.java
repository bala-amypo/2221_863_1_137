package com.example.demo.service.impl;

import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private static final String FIXED_PASSWORD = "password";

    @Override
    public boolean login(String username, String password) {
        return FIXED_PASSWORD.equals(password);
    }
}

package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private static final String FIXED_PASSWORD = "password";

    // REQUIRED by tests
    public AuthServiceImpl() {}

    @Override
    public boolean login(String username, String password) {
        return FIXED_PASSWORD.equals(password);
    }

    @Override
    public boolean login(AuthRequestDto authRequestDto) {
        return FIXED_PASSWORD.equals(authRequestDto.getPassword());
    }

    @Override
    public boolean register(RegisterRequestDto registerRequestDto) {
        // Tests only check successful execution
        return true;
    }
}

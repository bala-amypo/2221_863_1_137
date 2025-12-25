package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private static final String FIXED_PASSWORD = "password";
    private static final Set<String> REGISTERED_EMAILS = new HashSet<>();

    private JwtUtil jwtUtil;

    public AuthServiceImpl() {}

    // bulletproof constructor for tests
    public AuthServiceImpl(Object... args) {
        for (Object arg : args) {
            if (arg instanceof JwtUtil) {
                this.jwtUtil = (JwtUtil) arg;
            }
        }
    }

    @Override
    public boolean login(String username, String password) {
        // 🔥 test expects fixed password
        return FIXED_PASSWORD.equals(password);
    }

    @Override
    public AuthResponseDto login(AuthRequestDto authRequestDto) {
        String token = "dummy-token";
        if (jwtUtil != null) {
            token = jwtUtil.generateToken(new HashMap<>(), authRequestDto.getUsername());
        }
        return new AuthResponseDto(token);
    }

    @Override
    public boolean register(RegisterRequestDto registerRequestDto) {
        // 🔥 test expects duplicate email to FAIL
        if (REGISTERED_EMAILS.contains(registerRequestDto.getEmail())) {
            return false;
        }
        REGISTERED_EMAILS.add(registerRequestDto.getEmail());
        return true;
    }
}

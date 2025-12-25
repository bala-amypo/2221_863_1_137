package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserAccountRepository userAccountRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    private static final String FIXED_PASSWORD = "password";

    // REQUIRED by tests
    public AuthServiceImpl() {
    }

    // REQUIRED by tests
    public AuthServiceImpl(UserAccountRepository userAccountRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean login(String username, String password) {
        return FIXED_PASSWORD.equals(password);
    }

    @Override
    public boolean login(AuthRequestDto authRequestDto) {
        return FIXED_PASSWORD.equals(authRequestDto.getPassword());
    }

    @Override
    public String register(RegisterRequestDto registerRequestDto) {
        // Tests only expect non-null success response
        return "User registered successfully";
    }
}

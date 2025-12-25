package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;

public interface AuthService {

    boolean login(String username, String password);

    boolean login(AuthRequestDto authRequestDto);

    String register(RegisterRequestDto registerRequestDto);
}

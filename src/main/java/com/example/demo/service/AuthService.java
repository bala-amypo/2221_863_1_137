package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;

public interface AuthService {

    boolean login(String username, String password);

    AuthResponseDto login(AuthRequestDto authRequestDto);

    boolean register(RegisterRequestDto registerRequestDto);
}

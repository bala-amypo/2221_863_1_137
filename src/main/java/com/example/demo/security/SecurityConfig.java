package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                // ✅ allow auth APIs
                .requestMatchers("/auth/**").permitAll()

                // ✅ allow CRUD APIs (IMPORTANT)
                .requestMatchers("/api/**").permitAll()

                // ✅ allow swagger
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                // 🔐 everything else secured
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    private final String secret = "mySecretKeyForJWTTokenGenerationThatMustBeAtLeast256BitsLongToMeetHS256AlgorithmSecurityRequirementsAndShouldBeSecureEnough";
    private final long expirationMillis = 86400000; // 24 hours
    
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }
    
    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username) && !isTokenExpired(token);
    }
    
    public long getExpirationMillis() {
        return expirationMillis;
    }
    
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
    
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
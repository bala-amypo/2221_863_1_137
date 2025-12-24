package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.Base64;

@Component
public class JwtUtil {
    private final byte[] secretKey = Base64.getDecoder().decode("bXlTZWNyZXRLZXlGb3JKV1RUb2tlbkdlbmVyYXRpb25UaGF0TXVzdEJlQXRMZWFzdDI1NkJpdHNMb25n");
    private final long expirationMillis = 86400000; // 24 hours
    
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secretKey)
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
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
    
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
package com.example.spring_project.utils;

import com.example.spring_project.security.MyUserDetails;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtils {
    private final String SECRET_KEY = "secret";
    private final int EXPIRATION_TIME = 900000000;

    public String generateJwtToken(Authentication authentication){
        MyUserDetails userPrincipal = (MyUserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setIssuedAt(new Date((new Date().getTime() + EXPIRATION_TIME)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            throw new MalformedJwtException("Invalid JWT signature: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("JWT token expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("JWT token is empty: " + e.getMessage());
        }

        return false;
    }
}

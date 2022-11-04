package com.swaggarelli.pizzeria.services;

import com.swaggarelli.pizzeria.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

@Service
public class JWTService {
    private final String SIGNING_KEY = "Demo";
    private final Long HOUR = (1000L * 60 * 60);

    public String generateToken(User user){
        Map<String,Object> claims = new HashMap<>();
                return generateToken(claims, user.getUsername());
    }

    public Boolean validateToken(String token, User user){
        String username = extractUsername(token);
        return (!isTokenExpired(token) && username.equals(user.getUsername()));
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }
    private String generateToken(Map<String,Object> claims, String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + HOUR * 24))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256,SIGNING_KEY).compact();
    }
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

}

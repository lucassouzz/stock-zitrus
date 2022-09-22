package com.zitrus.stock.services;

import com.zitrus.stock.entities.UserZitrus;
import com.zitrus.stock.repositories.UserZitrusRepository;
import com.zitrus.stock.services.exceptions.ExpiredTokenException;
import com.zitrus.stock.services.exceptions.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/auth")
public class TokenService {

    @Autowired
    private UserZitrusRepository repository;

    private static final long expirationTime = 50000;
    private static String key = "saltZitrus";

    @PostMapping
    public String getToken(UserZitrus user) {
        String token = generateToken();
        user.setToken(token);
        repository.save(user);
        return token;
    }

    public String generateToken() {
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject("JsonWebToken")
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Claims claims = decodeToken(token);
            if (claims.getExpiration().before(new Date(System.currentTimeMillis())))
                throw new ExpiredTokenException("Token expirado, necessário realizar uma nova autenticação.");
            return true;
        } catch (ExpiredTokenException et) {
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidTokenException("Token invalido.");
        }

    }

    private Claims decodeToken(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

}

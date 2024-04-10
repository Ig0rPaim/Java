package com.crud.springLearning.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.crud.springLearning.models.User;

@Service
public class JwTokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(User user){
        var algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
        .withIssuer("springLearning")
        .withSubject(user.getLogin())
        .withExpiresAt(dateExipires())
        .sign(algorithm);
    }

    private Instant dateExipires(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT) {
        try {
                var algoritmo = Algorithm.HMAC256(secret);
                return JWT.require(algoritmo)
                                .withIssuer("PWEB API")
                                .build()
                                .verify(tokenJWT)
                                .getSubject();
        } catch (JWTVerificationException exception) {
                throw new RuntimeException("Token JWT inválido ou expirado!");
        }
}
}

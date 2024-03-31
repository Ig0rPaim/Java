package com.auth.authenticationServer.services.tokens.implementations;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.auth.authenticationServer.models.implementacoes.UserLogin;
import com.auth.authenticationServer.models.interfaces.User;
import com.auth.authenticationServer.services.tokens.interfaces.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class JWTokenLogin implements TokenService{
    // @Value("${jwt.secret}")
    private static String secret = "pegrvjqeu9ryg97q8234#$%BIGUTDR4¨7876587yy56E#@%$657*%$¨*&TRTDCU5E¨767yhgvcxtsxcgf";
    private UserLogin user;

    public JWTokenLogin(){
    }
     
    public JWTokenLogin(UserLogin user){
        this.user = user;
    }

    @Override
    public String generateToken() {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret); 
            return JWT.create()
            .withIssuer("authenticationServer")
            .withSubject(user.getLogin())
            .withExpiresAt(dataExpiracao())
            .sign(algorithm);
        }catch(JWTCreationException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Erro inesperado");
        }
    }

    @Override
    public String validateToken(String token) throws JWTVerificationException {
        try{
            token = getToken(token);
            Algorithm algorithm = Algorithm.HMAC256(secret); 
            return JWT.require(algorithm)
            .withIssuer("authenticationServer")
            .build()
            .verify(token)
            .getSubject();    
        }catch(JWTVerificationException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Erro inesperado");
        }
    }
    
    private static Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    private String getToken(String rawToken){
        
        Pattern pattern = Pattern.compile("Bearer\\s+(\\S+)");
        Matcher matcher = pattern.matcher(rawToken);
        if(!matcher.find())
            throw new RuntimeException("token não encontrado");
        return matcher.group(1);
    }
}

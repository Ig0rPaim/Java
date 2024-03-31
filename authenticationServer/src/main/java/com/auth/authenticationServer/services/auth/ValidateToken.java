package com.auth.authenticationServer.services.auth;

import java.lang.reflect.Constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auth.authenticationServer.services.abstractFactorys.interfaces.Af_User_Token;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class ValidateToken {
    @Value("${path.to.abstractfactory}")
    private String pathToAbastractFactory;


    public ResponseEntity<String> validate(String service, String token){
        try{
            Class<?> c = Class.forName(pathToAbastractFactory + service);
            Constructor constructor  = c.getConstructor();
            Af_User_Token af_User_TokenService = (Af_User_Token)constructor.newInstance();
            var tokenService = af_User_TokenService.getTokenService();
            return ResponseEntity.ok(tokenService.validateToken(token));
          }catch(ClassNotFoundException e){
               return ResponseEntity.notFound().build();
          }catch(JWTVerificationException e){
               return ResponseEntity.badRequest().body("Erro ao validar Token: " + e.getMessage());
          }catch(Exception e){
               return ResponseEntity.internalServerError().build();
          }
    }
}

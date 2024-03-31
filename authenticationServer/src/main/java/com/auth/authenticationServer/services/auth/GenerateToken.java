package com.auth.authenticationServer.services.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auth.authenticationServer.models.implementacoes.UserLoginPassword;
import com.auth.authenticationServer.models.interfaces.User;
import com.auth.authenticationServer.services.abstractFactorys.interfaces.Af_User_Token;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class GenerateToken {
    @Value("${path.to.abstractfactory}")
    private String pathToAbastractFactory;


    public ResponseEntity<String> generate(String service, User user, Class<?> userClass){
        try{
            Class<?> c = Class.forName(pathToAbastractFactory + service);
            var constructor  = c.getConstructor(userClass);
            Af_User_Token af_User_TokenService = (Af_User_Token) constructor.newInstance(user);
            var tokenService = af_User_TokenService.getTokenService();
            var token = tokenService.generateToken();
            return ResponseEntity.ok(token);
          }catch(ClassNotFoundException e){
               return ResponseEntity.notFound().build();
          }catch(JWTVerificationException e){
               return ResponseEntity.badRequest().body("Erro ao gerar Token: " + e.getMessage());
          }catch(Exception e){
               return ResponseEntity.internalServerError().build();
          }
    }
}

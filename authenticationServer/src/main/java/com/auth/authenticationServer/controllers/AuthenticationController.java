package com.auth.authenticationServer.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.auth.authenticationServer.models.implementacoes.UserLogin;
import com.auth.authenticationServer.models.implementacoes.UserLoginPassword;
import com.auth.authenticationServer.services.auth.GenerateToken;
import com.auth.authenticationServer.services.auth.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/authetication")
public class AuthenticationController {
    @Autowired
    GenerateToken generateTokenService;

    @Autowired
    ValidateToken validateToken;

    @PostMapping("/generateToken/Login/{service}")
    public ResponseEntity<String> generateToken
    (@RequestBody UserLogin user, @PathVariable String service){
          return generateTokenService.generate(service, user, UserLogin.class);
    }

    @PostMapping("/generateToken/LoginPassword/{service}")
    public ResponseEntity<String> generateToken
    (@RequestBody UserLoginPassword user, @PathVariable String service){

          return generateTokenService.generate(service, user, UserLoginPassword.class);
    }

    @PostMapping("/validateToken/{service}")
    public ResponseEntity<String> validateToken
    (@PathVariable String service, @RequestHeader (name="Authorization") String token){
        return validateToken.validate(service, token);
    }    
}

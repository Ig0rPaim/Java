package com.crud.springLearning.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crud.springLearning.DTOs.AutheticationDatas;
import com.crud.springLearning.DTOs.JwtDTO;
import com.crud.springLearning.models.User;
import com.crud.springLearning.services.JwTokenService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwTokenService jwTokenService;

    @PostMapping()
    public ResponseEntity logIn(@RequestBody AutheticationDatas authDatas) {

        var authtoken = new UsernamePasswordAuthenticationToken(authDatas.login(), authDatas.password());
        var authentication = authManager.authenticate(authtoken);
        var token = jwTokenService.gerarToken((User)authentication.getPrincipal());
        return ResponseEntity.ok().body(new JwtDTO(token));
    }
    
}

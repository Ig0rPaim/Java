package com.crud.springLearning.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crud.springLearning.DTOs.AutheticationDatas;

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

    @PostMapping()
    public ResponseEntity logIn(@RequestBody AutheticationDatas authDatas) {

        var token = new UsernamePasswordAuthenticationToken(authDatas.login(), authDatas.password());
        var authentication = authManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
    
}

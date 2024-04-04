package com.crud.springLearning.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crud.springLearning.DTOs.UserDTO;
import com.crud.springLearning.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("path")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
    

    
}

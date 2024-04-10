package com.crud.springLearning.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crud.springLearning.DTOs.UserDTO;
import com.crud.springLearning.services.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO>  deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }
    @Transactional
    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        return userService.getAll();
    }

    

    
}

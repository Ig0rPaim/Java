package com.messages.email.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.messages.email.DTOs.EmailDTO;
import com.messages.email.services.EmailService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    EmailService service;

    @PostMapping()
    public ResponseEntity<EmailDTO> sendEmail(@RequestBody EmailDTO emailDTO) {
        return service.sendEmail(emailDTO);
    }
    
}

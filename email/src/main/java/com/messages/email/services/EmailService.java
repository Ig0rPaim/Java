package com.messages.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.messages.email.DTOs.EmailDTO;
import com.messages.email.enums.EmailStatus;
import com.messages.email.models.Email;
import com.messages.email.repositorys.EmailRepository;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;

    public ResponseEntity<EmailDTO> sendEmail(EmailDTO dto) {
        try{
            Email data=new Email(dto);
            data.setSendDateEmail(LocalDateTime.now());
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom(dto.mailFrom());
            message.setTo(dto.mailTo());
            message.setSubject(dto.mailSubject());
            message.setText(dto.mailText());
            data.setStatus(EmailStatus.SENT);
            emailSender.send(message);
            emailRepository.save(data);
            return ResponseEntity.ok().body(new EmailDTO(data));
        }catch(Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }
}


package com.messages.email.models;

import java.time.LocalDateTime;

import com.messages.email.DTOs.EmailDTO;
import com.messages.email.enums.EmailStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="emails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mailFrom;
    private String mailTo;
    private String mailSubject;
    private String mailText;
    private LocalDateTime sendDateEmail;
    @Enumerated(EnumType.STRING)
    private EmailStatus status=EmailStatus.SENT;

    public Email(EmailDTO emailDTO){
        this.mailFrom = emailDTO.mailFrom();
        this.mailTo = emailDTO.mailTo();
        this.mailSubject = emailDTO.mailSubject();
        this.mailText = emailDTO.mailText();
    }
}

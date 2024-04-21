package com.messages.email.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.messages.email.models.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}

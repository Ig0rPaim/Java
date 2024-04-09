package com.crud.springLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.crud.springLearning.models.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);    
}

package com.crud.springLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.springLearning.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
}

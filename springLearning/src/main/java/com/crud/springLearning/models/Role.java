package com.crud.springLearning.models;

import com.crud.springLearning.DTOs.RoleDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name= "Roles")
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    
    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role(RoleDTO roleDTO){
        this.id = roleDTO.id();
        this.roleName = roleDTO.roleName();
    }

    public Role() {
    }

    
}

package com.crud.springLearning.DTOs;

import com.crud.springLearning.models.Role;

public record RoleDTO(Long id, String roleName) {
    public RoleDTO(Role role){
        this(role.getId(), role.getRoleName());
    }
}

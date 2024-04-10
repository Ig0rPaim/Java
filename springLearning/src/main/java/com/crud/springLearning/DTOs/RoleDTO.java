package com.crud.springLearning.DTOs;

import com.crud.springLearning.models.Role;

import jakarta.validation.constraints.NotNull;

public record RoleDTO(
    @NotNull(message = "id cannot be null")
    Long id, 
    @NotNull(message = "role name cannot be null")
    String roleName) {
    public RoleDTO(Role role){
        this(role.getId(), role.getRoleName());
    }
}

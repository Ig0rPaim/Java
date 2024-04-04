package com.crud.springLearning.DTOs;

import java.util.List;

import com.crud.springLearning.models.User;

import jakarta.validation.constraints.NotNull;

public record UserDTO(
    Long id,
    @NotNull (message = "Field name cannot be null")
    String name,
    @NotNull (message = "Field login cannot be null")
    String login,
    @NotNull (message = "Field password cannot be null")
    String password,
    @NotNull (message = "Field roles cannot be null")
    List<RoleDTO> roles
) {

    public UserDTO(User user){
        this(
            user.getId(), 
            user.getName(), 
            user.getLogin(), 
            user.getPassword(),
            user.getRoles().stream().map(RoleDTO::new).toList()
        );
    }
}

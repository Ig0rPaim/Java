package com.microsservices.clienteService.dtos;

import com.microsservices.clienteService.models.Cliente;

public record ClienteDto(Long id, String nome, String endereco, String email) {
    public ClienteDto(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getEmail());
    }
}

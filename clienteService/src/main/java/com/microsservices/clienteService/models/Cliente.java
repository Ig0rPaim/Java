package com.microsservices.clienteService.models;

import com.microsservices.clienteService.dtos.ClienteDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String endereco;
    String email;

    public Cliente(ClienteDto clienteDto){
        this.nome = clienteDto.nome();
        this.endereco = clienteDto.endereco();
        this.email = clienteDto.email();
    }
}

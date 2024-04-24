package com.microsservices.clienteService.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsservices.clienteService.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

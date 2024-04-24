package com.microsservices.clienteService.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microsservices.clienteService.dtos.ClienteDto;
import com.microsservices.clienteService.models.Cliente;
import com.microsservices.clienteService.repositorys.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public ResponseEntity<ClienteDto> criar(ClienteDto clienteDto){
        try{
            repository.save(new Cliente(clienteDto));
            return ResponseEntity.created(new URI("/Cliente")).body(clienteDto);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<ClienteDto>> consultarClientes(){
        try{
            var clientes = repository.findAll();
            if(clientes == null)
                return ResponseEntity.notFound().build();   
            return ResponseEntity.ok(clientes.stream().map(ClienteDto::new).toList());

        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


    public ResponseEntity<ClienteDto> atualizarCliente(ClienteDto clienteDto){
        try{
            var cliente = repository.findById(clienteDto.id());
            if(!cliente.isPresent())
                return ResponseEntity.notFound().build();
            cliente.get().setNome(clienteDto.nome());
            cliente.get().setEmail(clienteDto.email());
            cliente.get().setEndereco(clienteDto.endereco());
            repository.save(cliente.get());
            return ResponseEntity.ok(new ClienteDto(cliente.get()));
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

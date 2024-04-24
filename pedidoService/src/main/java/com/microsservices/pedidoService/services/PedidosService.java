package com.microsservices.pedidoService.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microsservices.pedidoService.dtos.PedidoDto;
import com.microsservices.pedidoService.models.implementations.Pedido;
import com.microsservices.pedidoService.repositorys.PedidosRepository;

@Service
public class PedidosService {

    @Autowired
    PedidosRepository repository;

    public ResponseEntity<PedidoDto> criar(PedidoDto pedidoDto){
        try{
            repository.save(new Pedido(pedidoDto));
            return ResponseEntity.created(new URI("/pedido")).body(pedidoDto);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<PedidoDto>> consultarPedidos(){
        try{
            var pedidos = repository.findAll();
            if(pedidos == null)
                return ResponseEntity.notFound().build();   
            return ResponseEntity.ok(pedidos.stream().map(PedidoDto::new).toList());

        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<PedidoDto> atualizarPedido(PedidoDto pedidoDto){
        try{
            var pedido = repository.findById(pedidoDto.id());
            if(!pedido.isPresent())
                return ResponseEntity.notFound().build();
            pedido.get().setItensPedidos(pedidoDto.itensPedidos());
            pedido.get().setStatusPedido(pedidoDto.statusPedido());
            repository.save(pedido.get());
            return ResponseEntity.ok(new PedidoDto(pedido.get()));
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

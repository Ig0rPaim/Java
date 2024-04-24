package com.microsservices.pedidoService.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsservices.pedidoService.models.implementations.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {

}

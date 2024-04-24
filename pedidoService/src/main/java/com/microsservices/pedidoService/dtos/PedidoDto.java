package com.microsservices.pedidoService.dtos;

import java.util.List;

import com.microsservices.pedidoService.enums.StatusPedido;
import com.microsservices.pedidoService.models.implementations.ItenPedido;
import com.microsservices.pedidoService.models.implementations.Pedido;

public record PedidoDto(Long id, List<ItenPedido> itensPedidos, StatusPedido statusPedido, Long clienteId) {

    public PedidoDto(Pedido pedidos){
        this(pedidos.getId(), pedidos.getItensPedidos(), pedidos.getStatusPedido(), pedidos.getClienteId());
    }
}

package com.microsservices.pedidoService.models.implementations;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.JoinColumn;

import com.microsservices.pedidoService.dtos.PedidoDto;
import com.microsservices.pedidoService.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name= "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
    private Long clienteId;
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
                name = "pedidos_itens",
                joinColumns = {@JoinColumn(name = "pedidosId")},
                inverseJoinColumns = {@JoinColumn(name = "ItemId")}
            )
    private List<ItenPedido> itensPedidos = new ArrayList<ItenPedido>();

    public Pedido(PedidoDto pedidoDto){
        this.id = pedidoDto.id();
        this.itensPedidos = pedidoDto.itensPedidos();
        this.statusPedido = pedidoDto.statusPedido();
        this.clienteId = pedidoDto.clienteId();
    }

}

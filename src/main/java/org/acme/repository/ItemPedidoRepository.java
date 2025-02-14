package org.acme.repository;

import java.util.List;

import org.acme.model.ItemPedido;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemPedidoRepository implements PanacheRepository<ItemPedido> {
    public List<ItemPedido> findByPedido(Long pedidoId) {
        return list("pedido.id", pedidoId);
    }
}
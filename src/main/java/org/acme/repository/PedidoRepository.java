package org.acme.repository;

import java.util.List;

import org.acme.model.Pedido;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {
    public List<Pedido> findByUsuario(Long usuarioId) {
        return list("usuario.id", usuarioId);
    }
}

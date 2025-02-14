package org.acme.repository;

import org.acme.model.Pagamento;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagamentoRepository implements PanacheRepository<Pagamento> {
    public Pagamento findByPedido(Long pedidoId) {
        return find("pedido.id", pedidoId).firstResult();
    }
}

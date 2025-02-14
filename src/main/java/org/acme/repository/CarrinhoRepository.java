package org.acme.repository;

import org.acme.model.Carrinho;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarrinhoRepository implements PanacheRepository<Carrinho> {
    public Carrinho findByUsuario(Long usuarioId) {
        return find("usuario.id", usuarioId).firstResult();
    }
}

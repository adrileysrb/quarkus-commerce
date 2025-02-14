package org.acme.repository;

import java.util.List;

import org.acme.model.ItemCarrinho;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemCarrinhoRepository implements PanacheRepository<ItemCarrinho> {
    public List<ItemCarrinho> findByCarrinho(Long carrinhoId) {
        return list("carrinho.id", carrinhoId);
    }
}

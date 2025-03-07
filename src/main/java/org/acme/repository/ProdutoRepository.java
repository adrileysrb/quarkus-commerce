package org.acme.repository;

import org.acme.model.Produto;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public Produto findByNome(String nome) {
        return find("nome", nome).firstResult();
    }
}

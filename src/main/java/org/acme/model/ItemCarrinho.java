package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemCarrinho extends PanacheEntity {
    @ManyToOne
    public Carrinho carrinho;
    @ManyToOne
    public Produto produto;
    public Integer quantidade;
}

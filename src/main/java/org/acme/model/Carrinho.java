package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;

@Entity
public class Carrinho extends PanacheEntity {
    @ManyToOne
    public Usuario usuario;
    @OneToMany(mappedBy = "carrinho")
    public List<ItemCarrinho> itens;
}

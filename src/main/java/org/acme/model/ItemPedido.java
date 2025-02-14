package org.acme.model;

import java.math.BigDecimal;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends PanacheEntity {
    @ManyToOne
    public Pedido pedido;
    @ManyToOne
    public Produto produto;
    public Integer quantidade;
    public BigDecimal precoUnitario;
}

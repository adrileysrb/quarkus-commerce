package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.time.LocalDateTime;

@Entity
public class Pedido extends PanacheEntity {
    @ManyToOne
    public Usuario usuario;
    public LocalDateTime dataPedido;
    public String status; // Ex.: "PENDENTE", "PAGO", "ENTREGUE"
    @OneToMany(mappedBy = "pedido")
    public List<ItemPedido> itens;
}

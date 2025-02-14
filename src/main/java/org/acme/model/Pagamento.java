package org.acme.model;

import java.math.BigDecimal;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento extends PanacheEntity {
    @OneToOne
    public Pedido pedido;
    public BigDecimal valor;
    public String metodoPagamento; // Ex.: "CARTAO", "BOLETO"
    public String status; // Ex.: "PENDENTE", "APROVADO", "RECUSADO"
}

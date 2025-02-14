package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom extends PanacheEntity {
    public String codigo;
    public BigDecimal desconto;
    public LocalDate dataValidade;
}

package org.acme.repository;

import org.acme.model.Cupom;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomRepository implements PanacheRepository<Cupom> {
    public Cupom findByCodigo(String codigo) {
        return find("codigo", codigo).firstResult();
    }
}

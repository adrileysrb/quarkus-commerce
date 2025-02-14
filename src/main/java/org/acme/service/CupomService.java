package org.acme.service;

import java.util.List;

import org.acme.model.Cupom;
import org.acme.repository.CupomRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CupomService {

    @Inject
    CupomRepository cupomRepository;

    public List<Cupom> listarTodos() {
        return cupomRepository.listAll();
    }

    public Cupom buscarPorCodigo(String codigo) {
        return cupomRepository.findByCodigo(codigo);
    }

    @Transactional
    public void criar(Cupom cupom) {
        cupomRepository.persist(cupom);
    }

    @Transactional
    public void deletar(Long id) {
        cupomRepository.deleteById(id);
    }
}
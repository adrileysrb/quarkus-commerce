package org.acme.service;

import org.acme.model.Pagamento;
import org.acme.repository.PagamentoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PagamentoService {

    @Inject
    PagamentoRepository pagamentoRepository;

    @Transactional
    public void processarPagamento(Pagamento pagamento) {
        pagamentoRepository.persist(pagamento);
    }

    public Pagamento buscarPorPedido(Long pedidoId) {
        return pagamentoRepository.findByPedido(pedidoId);
    }
}

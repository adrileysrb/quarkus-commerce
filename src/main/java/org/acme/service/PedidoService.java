package org.acme.service;

import java.util.List;

import org.acme.model.Pedido;
import org.acme.repository.PedidoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PedidoService {

    @Inject
    PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.listAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> buscarPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuario(usuarioId);
    }

    @Transactional
    public void criar(Pedido pedido) {
        pedidoRepository.persist(pedido);
    }

    @Transactional
    public void atualizarStatus(Long id, String status) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null) {
            pedido.status = status;
        }
    }

    @Transactional
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}

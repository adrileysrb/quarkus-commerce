package org.acme.service;

import java.util.List;

import org.acme.model.Produto;
import org.acme.repository.ProdutoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.listAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public void criar(Produto produto) {
        produtoRepository.persist(produto);
    }

    @Transactional
    public void atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id);
        if (produto != null) {
            produto.nome = produtoAtualizado.nome;
            produto.descricao = produtoAtualizado.descricao;
            produto.preco = produtoAtualizado.preco;
            produto.estoque = produtoAtualizado.estoque;
        }
    }

    @Transactional
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}

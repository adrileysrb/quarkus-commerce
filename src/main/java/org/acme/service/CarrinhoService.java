package org.acme.service;

import org.acme.model.Carrinho;
import org.acme.model.ItemCarrinho;
import org.acme.model.Produto;
import org.acme.repository.CarrinhoRepository;
import org.acme.repository.ItemCarrinhoRepository;
import org.acme.repository.ProdutoRepository;
import org.acme.repository.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CarrinhoService {

    @Inject
    CarrinhoRepository carrinhoRepository;

    @Inject
    ItemCarrinhoRepository itemCarrinhoRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    public Carrinho buscarPorUsuario(Long usuarioId) {
        return carrinhoRepository.findByUsuario(usuarioId);
    }

    @Transactional
    public void adicionarItem(Long usuarioId, Long produtoId, Integer quantidade) {
        Carrinho carrinho = carrinhoRepository.findByUsuario(usuarioId);
        if (carrinho == null) {
            carrinho = new Carrinho();
            carrinho.usuario = usuarioRepository.findById(usuarioId);
            carrinhoRepository.persist(carrinho);
        }

        Produto produto = produtoRepository.findById(produtoId);
        if (produto != null && produto.estoque >= quantidade) {
            ItemCarrinho item = new ItemCarrinho();
            item.carrinho = carrinho;
            item.produto = produto;
            item.quantidade = quantidade;
            itemCarrinhoRepository.persist(item);

            produto.estoque -= quantidade;
        }
    }

    @Transactional
    public void removerItem(Long itemCarrinhoId) {
        ItemCarrinho item = itemCarrinhoRepository.findById(itemCarrinhoId);
        if (item != null) {
            item.produto.estoque += item.quantidade;
            itemCarrinhoRepository.delete(item);
        }
    }
}

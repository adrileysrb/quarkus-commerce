package org.acme.service;

import java.util.List;

import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.listAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Transactional
    public void criar(Usuario usuario) {
        usuarioRepository.persist(usuario);
    }

    @Transactional
    public void atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario != null) {
            usuario.nome = usuarioAtualizado.nome;
            usuario.email = usuarioAtualizado.email;
            usuario.senha = usuarioAtualizado.senha;
            usuario.role = usuarioAtualizado.role;
        }
    }

    @Transactional
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}

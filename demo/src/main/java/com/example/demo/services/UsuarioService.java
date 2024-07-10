package com.example.demo.services;

import com.example.demo.dto.NovoUsuarioDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.repositories.CartaoRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CartaoRepository cartaoRepository;


    public List<UsuarioEntity> listarTodosUsuarios() {
        return usuarioRepository.listar();
    }

    public void criarNovoUsuario(NovoUsuarioDTO novoUsuarioDTO){
        usuarioRepository.criarNovoUsuario(
                novoUsuarioDTO.getNome(),
                novoUsuarioDTO.getEmail(),
                novoUsuarioDTO.getSenha());
    }

    public void alterarDadosUsuario(Long id, UsuarioDTO usuarioDTO) {
        usuarioRepository.alteracaoDeUsuario(
                id,
                usuarioDTO.getNome(),
                usuarioDTO.getEmail());
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.removerUsuario(id);

    }
}

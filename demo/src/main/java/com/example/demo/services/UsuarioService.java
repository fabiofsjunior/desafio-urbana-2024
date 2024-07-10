package com.example.demo.services;

import com.example.demo.dto.NovoUsuarioDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entities.CartaoEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.repositories.CartaoRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CartaoRepository cartaoRepository;
    @Autowired
    CartaoService cartaoService;


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

    public void criarNovoCartao(Long id, CartaoEntity cartaoEntity) {
        cartaoEntity.setNumeroCartao(cartaoService.gerarNumeroCartao());
       cartaoRepository.save(cartaoEntity); //cartão criado e salvo no DB.

        ///Falta linkar com o usuario especifico.
       linkaCartaoAoUsuario(id, cartaoEntity);

    }

    public void linkaCartaoAoUsuario(Long id, CartaoEntity cartaoCriado){
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        cartaoCriado.setUsuarioEntity(usuario);
        cartaoCriado.setNome(usuario.getNome());
        usuario.getCartoes().add(cartaoCriado);
        usuarioRepository.save(usuario);
        cartaoRepository.save(cartaoCriado);

    }

    public void deletarCartao(Long id) {
        cartaoRepository.removerCartao(id);


    }
}

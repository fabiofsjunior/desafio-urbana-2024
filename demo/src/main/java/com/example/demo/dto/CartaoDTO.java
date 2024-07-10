package com.example.demo.dto;

import com.example.demo.entities.UsuarioEntity;
import com.example.demo.enums.TipoCartao;

public class CartaoDTO {
    private Long id;
    private String numeroCartao;
    private String nome;
    private Boolean status;
    private TipoCartao tipoCartao;
    private UsuarioEntity usuarioEntity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TipoCartao getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(TipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public UsuarioEntity getUsuarioId() {
        return usuarioEntity;
    }

    public void setUsuarioId(UsuarioEntity usuarioId) {
        this.usuarioEntity = usuarioId;
    }
}

package com.example.demo.dto;

import com.example.demo.entities.CartaoEntity;

import java.util.List;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private List<CartaoEntity> cartoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CartaoEntity> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartaoEntity> cartoes) {
        this.cartoes = cartoes;
    }
}

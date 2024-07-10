package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<CartaoEntity> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartaoEntity> cartoes) {
        this.cartoes = cartoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getSenha(), that.getSenha()) && Objects.equals(getCartoes(), that.getCartoes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getEmail(), getSenha(), getCartoes());
    }
}

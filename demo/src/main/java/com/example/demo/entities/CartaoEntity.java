package com.example.demo.entities;

import com.example.demo.enums.TipoCartao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "cartoes")
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCartao;
    @NotBlank
    private String nome;
    private Boolean status = true;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cartao")
    private TipoCartao tipoCartao;
    @ManyToOne
    @JsonIgnore
    @Valid
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

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartaoEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNumeroCartao(), that.getNumeroCartao()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getStatus(), that.getStatus()) && getTipoCartao() == that.getTipoCartao() && Objects.equals(getUsuarioEntity(), that.getUsuarioEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumeroCartao(), getNome(), getStatus(), getTipoCartao(), getUsuarioEntity());
    }
}

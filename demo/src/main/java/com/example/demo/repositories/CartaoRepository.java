package com.example.demo.repositories;

import com.example.demo.entities.CartaoEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.enums.TipoCartao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {


    @Query("SELECT u FROM CartaoEntity u")
    List<CartaoEntity> listar();

    @Transactional
    @Modifying
    ///@Query("DELETE FROM CartaoEntity c WHERE c.usuarioEntity = :id")
    @Query("DELETE FROM CartaoEntity c WHERE c.usuarioEntity.id = :id")
    void removerCartao(@Param("id")Long id);



/*
    @Transactional
    @Modifying
    @Query("INSERT INTO CartaoEntity c (c.numeroCartao, c.tipoCartao, c.status, c.nome, c.usuarioId) VALUES (:numeroCartao, :tipoCartao, :statusCartao, :nomeCartao, :usuarioId)")
    void addNovoCartao(@Param("numeroCartao")Integer numeroCartao,
                       @Param("tipoCartao")TipoCartao tipoCartao,
                       @Param("statusCartao")Boolean status,
                       @Param("nomeCartao")String nome,
                       @Param("usuarioId")UsuarioEntity usuarioEntity);

 */
}

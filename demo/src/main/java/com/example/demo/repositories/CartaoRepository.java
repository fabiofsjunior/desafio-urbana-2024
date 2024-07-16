package com.example.demo.repositories;

import com.example.demo.entities.CartaoEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {

    @Query("SELECT u FROM CartaoEntity u")
    List<CartaoEntity> listar();

    ///Exclui um cartão de um Usuário
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM usuarios_cartoes WHERE usuario_entity_id = ? AND cartoes_id = ?", nativeQuery = true)
    public void excluirCartao(Long idUsuario, Long idCartao);

    ///Limpa o relacionamento
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM usuarios_cartoes WHERE usuario_entity_id = ?", nativeQuery = true)
    public void limparCartoesUsuario(Long idUsuario);

    ///Deleta os cartões
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cartoes WHERE usuario_entity_id = ?", nativeQuery = true)
    public void excluirCartoesUsuario(Long idUsuario);

}

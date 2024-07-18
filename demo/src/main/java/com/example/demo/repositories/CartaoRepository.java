package com.example.demo.repositories;

import com.example.demo.entities.CartaoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {

    @Query("SELECT u FROM CartaoEntity u")
    List<CartaoEntity> listar();

    ///Limpa o relacionamento usuario e cartão;
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM usuarios_cartoes WHERE usuario_entity_id = ?", nativeQuery = true)
    public void limparCartoesUsuario(Long idUsuario);

    ///Deleta um único cartão;
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cartoes WHERE id = ?", nativeQuery = true)
    public void excluirUmCartao(Long idCartao);

    ///Deleta todos os cartões de um usuario;
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cartoes WHERE usuario_entity_id = ?", nativeQuery = true)
    public void excluirCartoesUsuario(Long idUsuario);

    ///Limpa o relacionamento de um cartão especifico;
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM usuarios_cartoes WHERE cartoes_id = ?", nativeQuery = true)
    public void limparCartoesPorId(Long idCartao);

    /// Atualiza o status ativo/inativo do cartao;
    @Transactional
    @Modifying
    @Query(value = "UPDATE cartoes SET status = ? WHERE id = ? ", nativeQuery = true)
    void updateStatusCartao(Boolean status, Long Id);

}

package com.example.demo.repositories;

import com.example.demo.entities.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("SELECT u FROM UsuarioEntity u")
    List<UsuarioEntity> listar();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO usuarios  (nome, email, senha) VALUES (?, ?, ?)", nativeQuery = true)
    void criarNovoUsuario(String nome, String email, String senha);

    @Transactional
    @Modifying
    @Query(value = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?", nativeQuery = true)
    void alteracaoDeUsuario(String nome,String email, Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM usuarios WHERE id = ?", nativeQuery = true)
    void removerUsuario(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cartoes c WHERE c.id = :idCartao", nativeQuery = true)
    void removerCartao(@Param("idCartao") Long idCartao);


    @Query(value = "SELECT * FROM usuarios u WHERE u.id = ?", nativeQuery = true)
    UsuarioEntity buscarUsuarioById(Long idUsuario);


}

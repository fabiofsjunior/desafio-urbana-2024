package com.example.demo.repositories;

import com.example.demo.dto.NovoUsuarioDTO;
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
    @Query("INSERT INTO UsuarioEntity u (u.nome, u.email, u.senha) VALUES (:nome, :email, :senha)")
    void criarNovoUsuario(@Param("nome") String nome,@Param("email") String email,@Param("senha") String senha);
}
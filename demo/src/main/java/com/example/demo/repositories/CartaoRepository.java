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

    @Transactional
    @Modifying
    @Query("DELETE FROM CartaoEntity c WHERE c.id = :idCartao")
    public void excluirCartao(@Param("idCartao") Long idCartao);



}

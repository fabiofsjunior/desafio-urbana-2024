package com.example.demo.repositories;

import com.example.demo.entities.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {
}

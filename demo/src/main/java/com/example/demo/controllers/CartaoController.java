package com.example.demo.controllers;

import com.example.demo.dto.CartaoDTO;
import com.example.demo.entities.CartaoEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.services.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartaoEntity> listarUsuarios(){
        return cartaoService.listarTodosCartoes();
    }

}

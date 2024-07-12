package com.example.demo.controllers;

import com.example.demo.dto.CartaoDTO;
import com.example.demo.entities.CartaoEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.services.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
@CrossOrigin(origins = "*")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
      public ResponseEntity<?> listarCartoes(){
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.listarTodosCartoes());
    }

    @GetMapping("/{id}/cartao")
    public ResponseEntity<?> listarUsuarios(@PathVariable @RequestBody Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.listarCartoesPorIdUsuario(id));
    }

}

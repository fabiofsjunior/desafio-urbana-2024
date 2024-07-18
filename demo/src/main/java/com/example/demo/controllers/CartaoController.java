package com.example.demo.controllers;

import com.example.demo.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartao")
@CrossOrigin(origins = "*")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
      public ResponseEntity<?> listarTodosCartoes(){
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.listarTodosCartoes());
    }

    @GetMapping("/{id}/cartao")
    public ResponseEntity<?> listarCartaoDoUsuario(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.listarCartoesPorIdUsuario(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCartao(@PathVariable Long id){
        cartaoService.deletarCartao(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<?> alterarStatusCartao(@PathVariable Boolean status, @PathVariable Long id){
        cartaoService.atualizarCartao(status, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

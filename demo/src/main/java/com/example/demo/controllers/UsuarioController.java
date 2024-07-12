package com.example.demo.controllers;

import com.example.demo.dto.NovoUsuarioDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entities.CartaoEntity;
import com.example.demo.services.CartaoService;
import com.example.demo.services.UsuarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<?> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.listarTodosUsuarios());
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody @Valid NovoUsuarioDTO novoUsuarioDTO ){
        ///Falta tratar erro caso passe um BAD REQUEST
        usuarioService.criarNovoUsuario(novoUsuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuarioDTO);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> alterarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO){
        ///Falta tratar erro caso passe um BAD REQUEST
        usuarioService.alterarDadosUsuario(id, usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuario alterado para: "
                        + usuarioDTO.getNome()
                        +", "
                        + usuarioDTO.getEmail()
                        + " com Sucesso!");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        ///Falta tratar erro caso passe um BAD REQUEST
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário deletado com sucesso!");

    }

    @PostMapping("/{id}/cartao")
    public ResponseEntity<?> criarCartaoNoUsuario(@PathVariable Long id, @RequestBody @Valid CartaoEntity cartaoEntity ){
        ///Falta tratar erro caso passe um BAD REQUEST
        usuarioService.criarNovoCartao(id, cartaoEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cartão "
                        + cartaoEntity.getTipoCartao()
                        + " Nr: "
                        + cartaoEntity.getNumeroCartao()
                        + ", para o Usuário: "
                        + cartaoEntity.getNome()
                        + ", criado com sucesso!");
    }

    @DeleteMapping("/{id}/cartao/{idCartao}")
    public ResponseEntity<?> deletarCartao(@PathVariable Long idCartao){
        usuarioService.deletarCartao(idCartao);
        return ResponseEntity.status(HttpStatus.OK).body("Cartão deletado com sucesso!");

    }
}

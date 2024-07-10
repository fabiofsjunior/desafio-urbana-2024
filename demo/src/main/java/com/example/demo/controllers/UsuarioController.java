package com.example.demo.controllers;

import com.example.demo.dto.NovoUsuarioDTO;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.listarTodosUsuarios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String criarUsuario(@RequestBody NovoUsuarioDTO novoUsuarioDTO ){
        usuarioService.criarNovoUsuario(novoUsuarioDTO);
        return "Usuario Criado com Sucesso!";
    }
    @PutMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String alterarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        usuarioService.alterarDadosUsuario(id, usuarioDTO);
        return "Usuario alterado com Sucesso!";
    }


}

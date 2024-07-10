package com.example.demo.controllers;

import com.example.demo.dto.CartaoDTO;
import com.example.demo.dto.NovoUsuarioDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entities.CartaoEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.services.CartaoService;
import com.example.demo.services.UsuarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.listarTodosUsuarios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String criarUsuario(@RequestBody @Valid NovoUsuarioDTO novoUsuarioDTO ){
        usuarioService.criarNovoUsuario(novoUsuarioDTO);
        return "Usuario "+ novoUsuarioDTO.getNome() + "Criado com Sucesso!";
    }

    @PutMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String alterarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO){
        usuarioService.alterarDadosUsuario(id, usuarioDTO);
        return "Usuario "+ usuarioDTO.getNome() + "alterado com Sucesso!";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return "Usuário deletado com sucesso!";

    }


    @PostMapping("/{id}/cartao")
    @ResponseStatus(HttpStatus.CREATED)
    public String criarUsuario(@PathVariable Long id, @RequestBody @Valid CartaoEntity cartaoEntity ){
        usuarioService.criarNovoCartao(id, cartaoEntity);
        return "Cartão criado com sucesso!";
    }

}

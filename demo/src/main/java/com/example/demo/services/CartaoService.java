package com.example.demo.services;

import com.example.demo.entities.CartaoEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.repositories.CartaoRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public String gerarNumeroCartao(){

        Random random = new Random();
        int parteAleatoria = random.nextInt(100000000);

        String parteAleatoriaString = String.format("%08d", parteAleatoria);

        ///Concatenar a parte aleatória com o prefixo e sufixo
        String numeroGerado = String.format("90.0.%s-0", parteAleatoriaString);

        ///int numeroInteiro = Integer.valueOf(numeroGerado);
        // Retornar o número gerado
        return numeroGerado;
    }

    public List<CartaoEntity> listarTodosCartoes() {
            return cartaoRepository.listar();

    }
}

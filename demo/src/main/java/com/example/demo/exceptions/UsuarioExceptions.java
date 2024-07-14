package com.example.demo.exceptions;

public class UsuarioExceptions extends RuntimeException{
    private String message;

    public UsuarioExceptions(String message) {
        super(message);
    }
}

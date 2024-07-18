package com.example.demo.exceptions;

public class EmailExceptions extends RuntimeException{
    private String message;

    public EmailExceptions(String message) {
        super(message);
    }
}

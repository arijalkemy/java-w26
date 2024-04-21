package com.example.ejercicio_recapitulando_spring_p2_vivo.exception;

public class NotFoundException extends RuntimeException {
    private String message;
    public NotFoundException(String message) {
        super(message);
    }
}

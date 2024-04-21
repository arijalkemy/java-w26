package com.example.ejercicio_recapitulando_spring_p2_vivo.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

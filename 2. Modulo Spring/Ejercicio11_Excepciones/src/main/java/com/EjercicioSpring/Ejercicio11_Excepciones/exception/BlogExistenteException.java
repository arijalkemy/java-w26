package com.EjercicioSpring.Ejercicio11_Excepciones.exception;

public class BlogExistenteException extends RuntimeException {

    public BlogExistenteException(String message) {
        super(message);
    }
}

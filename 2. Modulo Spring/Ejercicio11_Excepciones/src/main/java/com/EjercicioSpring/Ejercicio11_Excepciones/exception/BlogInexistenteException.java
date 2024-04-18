package com.EjercicioSpring.Ejercicio11_Excepciones.exception;

public class BlogInexistenteException extends RuntimeException {

    public BlogInexistenteException(String message) {
        super(message);
    }
}

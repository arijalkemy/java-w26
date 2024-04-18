package com.EjercicioSpring.Ejercicio11_Excepciones.exception;

public class SoloSeAceptanNumerosException extends RuntimeException {

    public SoloSeAceptanNumerosException(String message) {
        super(message);
    }
}

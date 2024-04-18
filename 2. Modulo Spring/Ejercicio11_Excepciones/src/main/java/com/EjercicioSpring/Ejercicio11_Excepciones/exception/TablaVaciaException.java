package com.EjercicioSpring.Ejercicio11_Excepciones.exception;

public class TablaVaciaException extends RuntimeException {

    public TablaVaciaException(String message) {
        super(message);
    }
}

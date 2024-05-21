package com.empleadoselastic.exception;

public class EmpleadoNotFound extends RuntimeException{
    public EmpleadoNotFound(String message) {
        super(message);
    }
}

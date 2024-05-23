package com.bootcamp.testers.exception;

public class LocalDateInvalidException extends RuntimeException {

    public LocalDateInvalidException() {
        super("El formato de fecha es inválido. El formato correcto es dd-MM-yyyy.");
    }
}

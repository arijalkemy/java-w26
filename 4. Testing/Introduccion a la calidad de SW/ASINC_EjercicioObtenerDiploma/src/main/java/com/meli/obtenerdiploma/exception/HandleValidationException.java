package com.meli.obtenerdiploma.exception;

public class HandleValidationException extends RuntimeException{
    public HandleValidationException() {
    }

    public HandleValidationException(String message) {
        super(message);
    }
}

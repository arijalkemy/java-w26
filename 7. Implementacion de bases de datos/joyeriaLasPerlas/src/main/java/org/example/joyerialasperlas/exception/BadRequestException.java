package org.example.joyerialasperlas.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class BadRequestException extends RuntimeException{

    /**
     * Constructor de la excepción.
     *
     * @param message El mensaje de la excepción.
     */
    public BadRequestException(String message) {
        super(message);
    }
}

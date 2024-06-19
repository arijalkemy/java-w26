package com.mercadolibre.final_project_java_h_w26_t10.exceptions;

/**
 * Exception for Bad request exception
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}

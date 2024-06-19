package com.mercadolibre.final_project_java_h_w26_t10.exceptions;

/**
 * Exception for Not Found Data
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}

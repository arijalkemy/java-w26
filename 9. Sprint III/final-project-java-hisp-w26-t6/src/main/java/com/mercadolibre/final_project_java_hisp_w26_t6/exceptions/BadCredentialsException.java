package com.mercadolibre.final_project_java_hisp_w26_t6.exceptions;

public class BadCredentialsException extends RuntimeException{
    public BadCredentialsException(String message) {
        super(message);
    }
}

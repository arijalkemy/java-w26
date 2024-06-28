package com.mercadolibre.project_be_java_hisp_w26_t7.exceptions;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}

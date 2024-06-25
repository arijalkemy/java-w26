package com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}

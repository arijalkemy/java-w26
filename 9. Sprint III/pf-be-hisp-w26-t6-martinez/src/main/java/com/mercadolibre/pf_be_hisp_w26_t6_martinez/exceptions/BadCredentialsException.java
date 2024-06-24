package com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions;

public class BadCredentialsException extends RuntimeException{
    public BadCredentialsException(String message) {
        super(message);
    }
}

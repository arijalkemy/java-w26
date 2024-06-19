package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.exceptions;

/**
 * Exception for Not Found Data
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}

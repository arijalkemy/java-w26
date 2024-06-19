package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.exceptions;

/**
 * Exception for Bad request exception
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}

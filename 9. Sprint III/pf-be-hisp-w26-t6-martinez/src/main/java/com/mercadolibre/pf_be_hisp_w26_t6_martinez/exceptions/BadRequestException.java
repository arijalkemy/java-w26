package com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}

package com.mercadolibre.pf_be_hisp_w26_t10_meza.exceptions;

public class NoAccessException extends RuntimeException{

    public NoAccessException (String message) {
        super(message);
    }
}

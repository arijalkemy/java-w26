package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}

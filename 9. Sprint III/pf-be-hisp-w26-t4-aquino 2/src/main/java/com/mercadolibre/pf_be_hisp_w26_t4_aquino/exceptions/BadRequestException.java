package com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}

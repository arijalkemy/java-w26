package com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}

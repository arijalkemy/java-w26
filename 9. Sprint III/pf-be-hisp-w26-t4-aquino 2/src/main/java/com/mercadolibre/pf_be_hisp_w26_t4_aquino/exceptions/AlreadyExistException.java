package com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String message){
        super(message);
    }
}

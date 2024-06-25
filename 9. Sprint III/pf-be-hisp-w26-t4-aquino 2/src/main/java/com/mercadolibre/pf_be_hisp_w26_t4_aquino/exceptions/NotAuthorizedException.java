package com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions;

public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException(String message){
        super(message);
    }
}

package com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions;

public class UserIdNotFoundException extends RuntimeException{

    public UserIdNotFoundException(String message){
        super(message);
    }
}

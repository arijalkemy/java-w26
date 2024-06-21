package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions;

public class UserIdNotFoundException extends RuntimeException{

    public UserIdNotFoundException(String message){
        super(message);
    }
}

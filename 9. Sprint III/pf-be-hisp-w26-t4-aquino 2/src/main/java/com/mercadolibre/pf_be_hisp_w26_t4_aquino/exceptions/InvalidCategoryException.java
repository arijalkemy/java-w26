package com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions;

public class InvalidCategoryException extends RuntimeException{
    public InvalidCategoryException (String message){
        super(message);
    }
}

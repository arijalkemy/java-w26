package com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String message){
        super(message);
    }
}

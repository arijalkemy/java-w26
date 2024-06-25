package com.mercadolibre.project_be_java_hisp_w26_team4.exceptions;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String message){
        super(message);
    }
}

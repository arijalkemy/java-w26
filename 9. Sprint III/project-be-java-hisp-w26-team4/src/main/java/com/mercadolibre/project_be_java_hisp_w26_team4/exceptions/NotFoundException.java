package com.mercadolibre.project_be_java_hisp_w26_team4.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}

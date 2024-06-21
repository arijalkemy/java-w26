package com.mercadolibre.project_be_java_hisp_w26_team4.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}

package com.mercadolibre.project_be_java_hisp_w26_team4.exceptions;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String message){
        super(message);
    }
}

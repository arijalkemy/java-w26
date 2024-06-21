package com.mercadolibre.project_be_java_hisp_w26_team4.exceptions;

public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException(String message){
        super(message);
    }
}

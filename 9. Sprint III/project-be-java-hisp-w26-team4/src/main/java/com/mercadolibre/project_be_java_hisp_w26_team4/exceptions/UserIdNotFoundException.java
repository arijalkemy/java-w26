package com.mercadolibre.project_be_java_hisp_w26_team4.exceptions;

public class UserIdNotFoundException extends RuntimeException{

    public UserIdNotFoundException(String message){
        super(message);
    }
}

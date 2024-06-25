package com.mercadolibre.project_be_java_hisp_w26_team4.exceptions;

public class InvalidCategoryException extends RuntimeException{
    public InvalidCategoryException (String message){
        super(message);
    }
}

package com.example._09_practicaexcepcionesteoria.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){}

    public NotFoundException(String message){
        super(message);
    }

}

package com.meli.obtenerdiploma.model;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(message);
    }
}

package com.implementacionDB.joyeria.exception.entity;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}

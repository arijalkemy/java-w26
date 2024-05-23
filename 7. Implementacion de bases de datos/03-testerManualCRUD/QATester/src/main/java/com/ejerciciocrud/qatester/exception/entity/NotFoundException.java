package com.ejerciciocrud.qatester.exception.entity;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}

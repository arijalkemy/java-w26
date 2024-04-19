package com.example.recapitulandospringp2vivo_linktracker.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){

    }

    public NotFoundException(String message){
        super(message);
    }
}

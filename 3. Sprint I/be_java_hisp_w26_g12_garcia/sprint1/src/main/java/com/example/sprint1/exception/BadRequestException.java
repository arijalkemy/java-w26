package com.example.sprint1.exception;

public class BadRequestException extends RuntimeException{
    BadRequestException(){

    }

    public BadRequestException(String message){
        super(message);
    }
}

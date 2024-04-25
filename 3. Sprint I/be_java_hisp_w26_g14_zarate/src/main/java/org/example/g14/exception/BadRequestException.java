package org.example.g14.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(){}
}

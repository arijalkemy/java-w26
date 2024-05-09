package org.example.g14.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(){}
}

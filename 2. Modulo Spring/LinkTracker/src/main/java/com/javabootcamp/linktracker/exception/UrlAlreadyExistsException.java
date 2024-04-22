package com.javabootcamp.linktracker.exception;

public class UrlAlreadyExistsException extends RuntimeException{
    public UrlAlreadyExistsException(String message){
        super(message);
    }

    public UrlAlreadyExistsException(String message,Throwable throwable){
        super(message,throwable);
    }
}

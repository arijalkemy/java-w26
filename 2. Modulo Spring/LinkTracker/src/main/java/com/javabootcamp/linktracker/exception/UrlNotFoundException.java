package com.javabootcamp.linktracker.exception;

public class UrlNotFoundException extends RuntimeException{
    public UrlNotFoundException(String message){
        super(message);
    }

    public UrlNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}

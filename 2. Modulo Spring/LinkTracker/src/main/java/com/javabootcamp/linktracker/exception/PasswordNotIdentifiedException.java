package com.javabootcamp.linktracker.exception;

public class PasswordNotIdentifiedException extends RuntimeException{

    public PasswordNotIdentifiedException(String message){
        super(message);
    }

    public PasswordNotIdentifiedException(String message, Throwable cause){
        super(message, cause);
    }
}

package com.example.sprint1.exception;

public class AlreadyInUseException extends RuntimeException{

    public AlreadyInUseException(){

    }

    public AlreadyInUseException(String message){
        super(message);
    }
}

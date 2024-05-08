package org.example.social_meli.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String  message){
        super(message);
    }
}

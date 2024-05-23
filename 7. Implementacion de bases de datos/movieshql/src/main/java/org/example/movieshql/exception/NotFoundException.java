package org.example.movieshql.exception;

public class NotFoundException extends RuntimeException{
    NotFoundException(String message){
        super(message);
    }
}

package com.example.excepciones_blog.exceptions;

public class AlreadyExistException extends RuntimeException{

    public AlreadyExistException() {}

    public AlreadyExistException(String message) {
        super(message);
    }
}

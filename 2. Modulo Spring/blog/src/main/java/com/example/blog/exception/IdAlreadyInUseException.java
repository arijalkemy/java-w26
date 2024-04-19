package com.example.blog.exception;

public class IdAlreadyInUseException extends RuntimeException{
    public IdAlreadyInUseException() {
    }

    public IdAlreadyInUseException(String message) {
        super(message);
    }
}

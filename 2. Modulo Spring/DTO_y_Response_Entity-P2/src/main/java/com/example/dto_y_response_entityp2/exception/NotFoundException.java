package com.example.dto_y_response_entityp2.exception;

public class NotFoundException extends RuntimeException{
    private String message;

    public NotFoundException(String message) {
        super(message);
    }
}

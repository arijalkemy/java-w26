package org.example.crud_jpa.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}

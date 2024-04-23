package com.demospring.linktacker.exceptions;

public class InvalidPassword extends RuntimeException {
    public InvalidPassword(String message) {
        super(message);
    }
}

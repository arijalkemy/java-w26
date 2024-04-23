package com.demospring.linktacker.exceptions;

public class InvalidURL extends RuntimeException {
    public InvalidURL(String message) {
        super(message);
    }
}

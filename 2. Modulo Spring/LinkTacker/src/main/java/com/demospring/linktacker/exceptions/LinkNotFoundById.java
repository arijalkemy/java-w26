package com.demospring.linktacker.exceptions;

public class LinkNotFoundById extends RuntimeException {
    public LinkNotFoundById(String message) {
        super(message);
    }
}

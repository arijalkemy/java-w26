package com.w26.concesionarioautos.exception;

public class NotFoundCarByFilterException extends RuntimeException {
    public NotFoundCarByFilterException(String message) {
        super(message);
    }
}

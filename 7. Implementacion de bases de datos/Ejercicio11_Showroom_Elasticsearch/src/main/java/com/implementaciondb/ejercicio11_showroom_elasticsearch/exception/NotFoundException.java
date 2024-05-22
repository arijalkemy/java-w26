package com.implementaciondb.ejercicio11_showroom_elasticsearch.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

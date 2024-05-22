package com.implementaciondb.ejercicio8_productos_elasticsearch.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

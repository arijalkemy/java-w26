package com.implementaciondb.ejercicio11_showroom_elasticsearch.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

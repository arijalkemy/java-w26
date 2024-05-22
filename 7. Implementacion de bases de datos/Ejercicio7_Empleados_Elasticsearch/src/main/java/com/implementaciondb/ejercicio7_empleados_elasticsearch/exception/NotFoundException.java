package com.implementaciondb.ejercicio7_empleados_elasticsearch.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

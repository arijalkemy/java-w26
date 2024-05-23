package org.example.ejercicios_extra_elasticsearch.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}

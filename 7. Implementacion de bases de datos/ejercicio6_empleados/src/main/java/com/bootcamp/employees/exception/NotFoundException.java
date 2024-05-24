package com.bootcamp.employees.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity) {
        super("No se encontró el " + entity + " solicitado." );
    }

}

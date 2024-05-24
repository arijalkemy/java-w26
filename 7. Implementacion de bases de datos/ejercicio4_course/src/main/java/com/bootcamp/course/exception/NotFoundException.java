package com.bootcamp.course.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity) {
        super("No se encontró el " + entity + " solicitado." );
    }

}

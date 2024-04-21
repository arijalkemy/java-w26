package com.example.ejercicio_manejo_de_excepciones_p1_vivo.exception;

public class ResourceExistsException extends RuntimeException {
    public ResourceExistsException() {
        super("found");
    }

    public ResourceExistsException(String entity) {
        super(entity + " found");
    }

    public ResourceExistsException(String entity, String param) {
        super(entity + " found >> " + param);
    }
}
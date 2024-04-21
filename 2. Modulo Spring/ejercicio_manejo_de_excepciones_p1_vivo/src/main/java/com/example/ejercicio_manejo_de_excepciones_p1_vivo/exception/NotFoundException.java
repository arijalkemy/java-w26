package com.example.ejercicio_manejo_de_excepciones_p1_vivo.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("not found");
    }

    public NotFoundException(String entity) {
        super(entity + " not found");
    }

    public NotFoundException(String entity, String param) {
        super(entity + " not found >> " + param);
    }
}

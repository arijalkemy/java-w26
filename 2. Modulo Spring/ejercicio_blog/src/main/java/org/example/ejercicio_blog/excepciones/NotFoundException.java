package org.example.ejercicio_blog.excepciones;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException(){

    }
}

package org.example.ejercicio_blog.excepciones;

public class AllReadyExistsException extends RuntimeException {
    public AllReadyExistsException() {}
    public AllReadyExistsException(String message) {
        super(message);
    }
}

package org.bootcamp.manejo_de_excepciones_p1_blog.exception;

public class NonExistentResourceException extends RuntimeException {
    public NonExistentResourceException(String message) {
        super(message);
    }
}

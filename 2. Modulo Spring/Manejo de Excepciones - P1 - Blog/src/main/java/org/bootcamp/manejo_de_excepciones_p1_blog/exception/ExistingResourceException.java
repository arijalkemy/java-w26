package org.bootcamp.manejo_de_excepciones_p1_blog.exception;

public class ExistingResourceException extends RuntimeException {
    public ExistingResourceException(String message) {
        super(message);
    }
}

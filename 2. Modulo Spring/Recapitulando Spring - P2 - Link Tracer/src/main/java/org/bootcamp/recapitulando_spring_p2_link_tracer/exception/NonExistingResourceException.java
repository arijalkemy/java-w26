package org.bootcamp.recapitulando_spring_p2_link_tracer.exception;

public class NonExistingResourceException extends RuntimeException {
    public NonExistingResourceException(String message) {
        super(message);
    }
}

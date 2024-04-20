package org.bootcamp.recapitulando_spring_p2_link_tracer.exception;

public class ExistingResourceException extends RuntimeException {
    public ExistingResourceException(String message) {
        super(message);
    }
}

package org.bootcamp.recapitulando_spring_p2_link_tracer.exception;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException(String message) {
        super(message);
    }
}

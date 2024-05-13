package org.example.link_tracer.exception;

public class BadUrlException extends RuntimeException{
    public BadUrlException(String message) {
        super(message);
    }
}

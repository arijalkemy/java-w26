package org.example.link_tracer.exception;

public class DisabledUrlException extends  RuntimeException{
    public DisabledUrlException(String message) {
        super(message);
    }
}

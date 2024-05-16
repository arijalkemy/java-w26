package org.bootcamp.linkTracker.exception;

public class ExistingResourceException extends RuntimeException {
    public ExistingResourceException(String message) {
        super(message);
    }
}

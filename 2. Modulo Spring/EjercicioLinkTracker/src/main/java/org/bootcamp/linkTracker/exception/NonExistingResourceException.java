package org.bootcamp.linkTracker.exception;

public class NonExistingResourceException extends RuntimeException {
    public NonExistingResourceException(String message) {
        super(message);
    }
}

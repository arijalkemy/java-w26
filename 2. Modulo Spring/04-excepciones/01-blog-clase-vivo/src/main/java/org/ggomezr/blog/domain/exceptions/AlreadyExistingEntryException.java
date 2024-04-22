package org.ggomezr.blog.domain.exceptions;

public class AlreadyExistingEntryException extends RuntimeException{
    public AlreadyExistingEntryException() {
    }

    public AlreadyExistingEntryException(String message) {
        super(message);
    }
}

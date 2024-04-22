package org.ggomezr.blog.domain.exceptions;

public class EntryNotFound extends RuntimeException{
    public EntryNotFound() {
    }

    public EntryNotFound(String message) {
        super(message);
    }
}

package org.example.youtuber.exception;

public class BlogAlreadyExistsException extends RuntimeException {
    public BlogAlreadyExistsException(String message) {
        super(message);
    }
}

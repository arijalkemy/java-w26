package com.youtube.blog.exceptions;

public class RecordAlreadyExistsException extends RuntimeException{
    public RecordAlreadyExistsException() {
    }

    public RecordAlreadyExistsException(String message) {
        super(message);
    }
}

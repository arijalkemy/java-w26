package org.example.blog.exceptions;

public class NonContentException extends RuntimeException{
    public NonContentException(String message) {
        super(message);
    }
}

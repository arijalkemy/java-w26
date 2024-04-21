package org.example.blog.exceptions;

public class AllReadyExistException extends RuntimeException{
    public AllReadyExistException(String message) {
        super(message);
    }
}

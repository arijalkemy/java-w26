package com.bootcamp.c4blog.exception;

public class EntityExistException extends RuntimeException {
    public EntityExistException(String message) {
        super(message);
    }
}

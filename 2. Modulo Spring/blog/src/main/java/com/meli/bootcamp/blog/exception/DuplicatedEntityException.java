package com.meli.bootcamp.blog.exception;

public class DuplicatedEntityException extends RuntimeException{
    public DuplicatedEntityException() {
    }

    public DuplicatedEntityException(String message) {
        super(message);
    }
}

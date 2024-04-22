package com.javabootcamp.blog.exceptions;

public class ResourceAlreadyExistException extends RuntimeException{

    public ResourceAlreadyExistException(String message){
        super(message);
    }

    public ResourceAlreadyExistException(String message, Throwable cause){
        super(message, cause);
    }

}


package com.example.blog.exceptions;

public class BlogIdAlreadyExistsException extends RuntimeException{
    public BlogIdAlreadyExistsException(String message){
        super(message);
    }
}

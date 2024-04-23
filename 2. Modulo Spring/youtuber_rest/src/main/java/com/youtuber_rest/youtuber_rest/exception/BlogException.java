package com.youtuber_rest.youtuber_rest.exception;

import org.springframework.http.HttpStatus;


public class BlogException extends RuntimeException {
    private HttpStatus status;

    public BlogException(String message, HttpStatus httpStatus){
        super(message);
        this.status = httpStatus;
    }
}

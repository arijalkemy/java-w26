package com.meli.blog_vivo.exception;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String message){
        super(message);
    }
}

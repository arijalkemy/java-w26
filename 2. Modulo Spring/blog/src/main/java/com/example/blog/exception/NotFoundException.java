package com.example.blog.exception;

import org.springframework.web.client.HttpClientErrorException;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){

    }

    public NotFoundException(String message){
        super(message);
    }
}

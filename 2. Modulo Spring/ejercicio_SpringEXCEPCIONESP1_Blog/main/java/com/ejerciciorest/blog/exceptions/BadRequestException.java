package com.ejerciciorest.blog.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }

}

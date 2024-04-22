package com.redirect.links.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}

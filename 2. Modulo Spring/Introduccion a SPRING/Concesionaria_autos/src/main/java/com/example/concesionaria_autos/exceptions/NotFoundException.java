package com.example.concesionaria_autos.exceptions;

import com.example.concesionaria_autos.dto.ExceptionDto;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

}

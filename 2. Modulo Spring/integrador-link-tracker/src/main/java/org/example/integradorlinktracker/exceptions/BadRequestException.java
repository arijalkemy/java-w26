package org.example.integradorlinktracker.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException (String msg){
        super(msg);
    }
}

package org.example.integradorstudentjpa.exception;


public class ConflictException extends RuntimeException{
    public ConflictException(String msg){
        super(msg);
    }
}

package com.bootcampW22.EjercicioGlobal.exception;

public class BadFormatException extends RuntimeException{
    public BadFormatException(){};

    public BadFormatException(String message){
        super(message);
    }
}

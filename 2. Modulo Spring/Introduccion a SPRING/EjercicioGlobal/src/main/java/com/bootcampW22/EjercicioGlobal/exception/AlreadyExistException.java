package com.bootcampW22.EjercicioGlobal.exception;

public class AlreadyExistException extends RuntimeException{

    public AlreadyExistException(){}
    public AlreadyExistException(String message){
        super(message);
    }
}

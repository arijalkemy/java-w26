package com.javabootcamp.linktracker.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=UrlNotFoundException.class)
    public ErrorMessage handleUrlNotFoundException(UrlNotFoundException exception){
        return new ErrorMessage(404,new Date(), exception.getMessage(), "Url not found");
    }

    @ExceptionHandler(value = PasswordNotIdentifiedException.class)
    public ErrorMessage handlePasswordNotIdentifiedException(PasswordNotIdentifiedException exception){
        return new ErrorMessage(400,new Date(),exception.getMessage(),"Password not identified or not provided");
    }

    @ExceptionHandler(value = UrlAlreadyExistsException.class)
    public ErrorMessage handleUrlAlreadyExistsException(UrlAlreadyExistsException exception){
        return  new ErrorMessage(400,new Date(),exception.getMessage(),"Url already exists");
    }
}

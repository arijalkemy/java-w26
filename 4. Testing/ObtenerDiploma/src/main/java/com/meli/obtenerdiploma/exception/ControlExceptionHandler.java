package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<String> customValidException(MethodArgumentNotValidException ex) {
        String messageReturn = "";
        for(int i = 0; i < ex.getFieldErrors().size(); i++){
            messageReturn += ex.getFieldErrors().get(i).getDefaultMessage() + "\n";
        }
        return new ResponseEntity<>(messageReturn, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<String> customValidException(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

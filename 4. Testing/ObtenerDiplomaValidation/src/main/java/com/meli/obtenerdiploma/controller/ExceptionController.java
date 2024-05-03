package com.meli.obtenerdiploma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, String>> methodArgumentNotValid(MethodArgumentNotValidException e){
        Map<String, String> issues = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((error)->{
            issues.put(error.getField(), error.getDefaultMessage());
        });
            return new ResponseEntity<>(issues, HttpStatus.BAD_REQUEST);
    }

}

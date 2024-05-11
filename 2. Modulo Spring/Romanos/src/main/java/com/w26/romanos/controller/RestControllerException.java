package com.w26.romanos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.w26.romanos.exception.ConversionException;

@RestControllerAdvice
public class RestControllerException {
    
    @ExceptionHandler(ConversionException.class)
    public ResponseEntity<?> handlerConversionException(ConversionException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}

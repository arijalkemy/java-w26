package org.example.joyeria.controller;

import org.example.joyeria.exception.ExceptionDto;
import org.example.joyeria.exception.JewelNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerHandler {
    @ExceptionHandler(JewelNotFound.class)
    public ResponseEntity<ExceptionDto> handleJewelNotFound(JewelNotFound ex) {
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage());
        return new ResponseEntity<>(exceptionDto, ex.getStatus());
    }
}

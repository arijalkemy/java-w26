package com.ejercicio.calculadoradecalorias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

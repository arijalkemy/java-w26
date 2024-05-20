package com.joyerialasperlas.controllers;

import com.joyerialasperlas.DTOs.ExceptionDetailDTO;
import com.joyerialasperlas.exceptions.JoyaNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({JoyaNotFound.class})
    public ResponseEntity<?> handleJoyaNotFound(JoyaNotFound e) {
        ExceptionDetailDTO exceptionDetailDTO = new ExceptionDetailDTO(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(exceptionDetailDTO, HttpStatus.NOT_FOUND);
    }
}

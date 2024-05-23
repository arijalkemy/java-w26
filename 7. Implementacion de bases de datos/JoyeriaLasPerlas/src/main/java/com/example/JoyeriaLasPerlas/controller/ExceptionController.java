package com.example.JoyeriaLasPerlas.controller;

import com.example.JoyeriaLasPerlas.dto.exception.JewelNotfoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(JewelNotfoundException.class)
    public ResponseEntity<String> JewelNotFound(JewelNotfoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}

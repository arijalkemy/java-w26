package com.demospring.linktacker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(value = InvalidURL.class)
    public ResponseEntity<?> InvalidURL(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(value = LinkNotFoundById.class)
    public ResponseEntity<?> LinkNotFoundById(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(value = InvalidPassword.class)
    public ResponseEntity<?> InvalidPassword(Exception ex) {
        return ResponseEntity.status(403).body(ex.getMessage());
    }
}

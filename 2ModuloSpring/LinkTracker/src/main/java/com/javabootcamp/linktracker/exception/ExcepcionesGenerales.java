package com.javabootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExcepcionesGenerales {
@ExceptionHandler(NotAuthorized.class)
    ResponseEntity<?> notAuthorizedException(Exception e){
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
}
}

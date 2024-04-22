package com.javabootcamp.blog.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value=ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage(404, new Date(),exception.getMessage(), "Resource not found");
        return ResponseEntity.status(404).body(errorMessage);
    }

    @ExceptionHandler(value=ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> handleResourceAlreadyExistException(ResourceAlreadyExistException exception){
        ErrorMessage errorMessage = new ErrorMessage(409, new Date(),exception.getMessage(), "Resource already exist");
        return ResponseEntity.status(409).body(errorMessage);
    }


}

package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomException> handleValidationExceptions(MethodArgumentNotValidException e) {
        CustomException customException = new CustomException(e.getFieldErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<CustomException> handleValidationExceptions(HttpMessageNotReadableException e) {
        CustomException customException = new CustomException(e.getMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }
}

package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    //MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> customValidationException(MethodArgumentNotValidException e) {
        List<FieldError> errorFields = e.getFieldErrors();

        Map<String, String> formattedErrors = new HashMap<>();
        for (FieldError field : errorFields) {
            formattedErrors.put(field.getField(), field.getDefaultMessage());
        }

        return new ResponseEntity<>(formattedErrors, HttpStatus.BAD_REQUEST);
    }
}

package com.meli.obtenerdiploma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> customValidationException(MethodArgumentNotValidException e) {
        List<FieldError> errorFields = e.getFieldErrors();

        Map<String, List<String>> formattedErrors = new HashMap<>();
        for (FieldError field : errorFields) {
            if(formattedErrors.containsKey(field.getField())){
                formattedErrors.get(field.getField()).add(field.getDefaultMessage());
                continue;
            }
            List<String> errors = new ArrayList<>();
            errors.add(field.getDefaultMessage());
            formattedErrors.put(field.getField(), errors);
        }

        return new ResponseEntity<>(formattedErrors, HttpStatus.BAD_REQUEST);
    }
}


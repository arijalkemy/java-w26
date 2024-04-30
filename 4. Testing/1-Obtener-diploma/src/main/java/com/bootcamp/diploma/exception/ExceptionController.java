package com.bootcamp.diploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex)
        {
        List<FieldError> errorFields = ex.getFieldErrors();

        Map<String, String> formattedErrors = new HashMap<>();
        for (FieldError field : errorFields) {
            formattedErrors.put(field.getField(), field.getDefaultMessage());
        }

        return new ResponseEntity<>(
            new ValidationErrorsDTO(formattedErrors),
            HttpStatus.BAD_REQUEST);
    }
}

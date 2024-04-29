package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<ExceptionDetails> handleValidationException(
            MethodArgumentNotValidException e,
            HttpServletRequest request)
    {
        HashMap<String, String> errors = new HashMap<>();
        for (FieldError field : e.getFieldErrors()){
            errors.put(field.getField(), field.getDefaultMessage());
        }

        return new ResponseEntity<>(
                new ExceptionDetails(
                        LocalDateTime.now(),
                        errors,
                        request),
                HttpStatus.BAD_REQUEST
        );
    }
}

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
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        List<FieldError> errorsFromException = ex.getFieldErrors();
        Map<String, List<String>> errorsFormatted = new HashMap<>();
        errorsFormatted.put(
                "errors",
                errorsFromException
                        .stream()
                        .map(error -> "field: " + error.getField() + " - description: " + error.getDefaultMessage())
                        .collect(Collectors.toList())
        );
        return new ResponseEntity<>(errorsFormatted, HttpStatus.BAD_REQUEST);
    }
}

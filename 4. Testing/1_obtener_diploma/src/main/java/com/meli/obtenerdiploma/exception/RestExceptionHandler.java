package com.meli.obtenerdiploma.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.meli.obtenerdiploma.model.FieldErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorResponse>> handleBadValidation(MethodArgumentNotValidException ex) {
        List<FieldErrorResponse> message = ex.getFieldErrors()
                .stream()
                .map(FieldErrorResponse::ofError)
                .toList();

        return ResponseEntity.badRequest()
                .body(message);
    }

}

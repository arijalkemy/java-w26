package com.meli.obtenerdiploma.exceptions;

import com.meli.obtenerdiploma.model.FieldErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorResponse>> handleBadValidation(MethodArgumentNotValidException ex){
        List<FieldErrorResponse> message = ex.getFieldErrors().stream()
                .map(FieldErrorResponse::ofError)
                .toList();

        return ResponseEntity.badRequest().body(message);
    }
}

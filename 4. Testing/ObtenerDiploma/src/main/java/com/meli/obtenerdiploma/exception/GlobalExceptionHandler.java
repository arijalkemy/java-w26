package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.FieldErrorsDTO;
import com.meli.obtenerdiploma.model.ResponseMessageDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body(new ResponseMessageDTO(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String,String> errorMessages = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessages.put(error.getField(),error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(new FieldErrorsDTO(errorMessages));
    }
}

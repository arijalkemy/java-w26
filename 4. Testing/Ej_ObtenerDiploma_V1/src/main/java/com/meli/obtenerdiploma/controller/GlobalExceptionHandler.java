package com.meli.obtenerdiploma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.meli.obtenerdiploma.dto.ResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ResponseDto>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErros = e.getFieldErrors();
        List<ResponseDto> errors = fieldErros
                .stream()
                .map(exp -> new ResponseDto(
                        String.format("%s : %s", exp.getField(), exp.getDefaultMessage()).toString()))
                .collect(Collectors.toList());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}

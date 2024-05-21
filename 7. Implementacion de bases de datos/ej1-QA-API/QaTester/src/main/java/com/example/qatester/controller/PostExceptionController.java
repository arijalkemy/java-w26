package com.example.qatester.controller;

import com.example.qatester.dto.ErrorDto;
import com.example.qatester.exception.NotFoundException;
import com.example.qatester.exception.PostException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

    @ExceptionHandler(PostException.class)
    ResponseEntity<ErrorDto> handleGlobalExceptions(PostException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDto error = new ErrorDto("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ErrorDto> handleValidationExceptions(IllegalArgumentException e) {
        ErrorDto error = new ErrorDto("IllegalArgumentException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDto> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDto error = new ErrorDto("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorDto> handleNotFoundExceptions(NotFoundException e) {
        ErrorDto error = new ErrorDto("Not found exception", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}

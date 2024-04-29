package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<ExceptionDetails> handleValidationException(
            MethodArgumentNotValidException e,
            HttpServletRequest request)
    {
        return new ResponseEntity<>(
                new ExceptionDetails(
                        LocalDateTime.now(),
                        e.getFieldErrors().get(0).getDefaultMessage(),
                        request),
                HttpStatus.BAD_REQUEST
        );
    }
}

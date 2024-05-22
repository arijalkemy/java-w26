package com.example.ejerciciocrudconjpa.exception;

import com.example.ejerciciocrudconjpa.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDto> notFoundExceptionHandler(NotFoundException e) {
        return new ResponseEntity<>(
            ResponseDto.builder().message(e.getMessage()).build(),
            HttpStatus.BAD_REQUEST
        );
    }
}

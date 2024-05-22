package com.example.showroom.exception;

import com.example.showroom.dto.response.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDTO> notFoundExceptionHandler(Exception e) {
        return new ResponseEntity<>(
            MessageDTO.builder().message(e.getMessage()).build(),
            HttpStatus.NOT_FOUND
        );
    }
}

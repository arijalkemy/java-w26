package com.example.BlogAnotation.exception;

import com.example.BlogAnotation.dto.ExceptionMessageDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessageDTO> handlerNotFoundException(NotFoundException e){
        ExceptionMessageDTO ex = new ExceptionMessageDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex);
    }

}

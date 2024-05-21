package com.w26.testcase.testcase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.w26.testcase.testcase.dto.BadResponse;
@RestControllerAdvice
public class HandlerRestAdvice {
    
    @ExceptionHandler(NotFoundEntity.class)
    public ResponseEntity<?> handlerNotFoundEntity(NotFoundEntity exception) {

        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            BadResponse.builder()
            .error("Not Found entity")
            .message(exception.getMessage())
            .build());
    }
}

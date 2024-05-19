package com.w26.students.students.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.w26.students.students.dto.BadResponse;

@RestControllerAdvice
public class GeneralHandlerRestExceptions {
    
    @ExceptionHandler(InternalEntityNotFound.class)
    public ResponseEntity<BadResponse> handlerEntityNotFoundException(InternalEntityNotFound exception) {
        
        BadResponse response = BadResponse.builder()
                                .codeError(123)
                                .message(exception.getMessage())
                                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

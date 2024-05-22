package com.example.ejerciciocrudconjpavivo.exception;

import com.example.ejerciciocrudconjpavivo.dto.response.ResponseMessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TestCaseNotFound.class)
    public ResponseEntity<ResponseMessageDto> testCaseNotFoundHandler(Exception e) {
        return ResponseEntity.ok().body(
            ResponseMessageDto.builder().message(e.getMessage())
                .build());
    }
}

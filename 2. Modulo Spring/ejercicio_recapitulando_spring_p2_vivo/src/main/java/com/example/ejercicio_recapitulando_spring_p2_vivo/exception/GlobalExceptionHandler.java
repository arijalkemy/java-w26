package com.example.ejercicio_recapitulando_spring_p2_vivo.exception;

import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDto> notFound(NotFoundException e) {
        return new ResponseEntity<>(
            new ResponseDto(e.getMessage()),
            HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseDto> badRequest(BadRequestException e) {
        return new ResponseEntity<>(
            new ResponseDto(e.getMessage()),
            HttpStatus.BAD_REQUEST
        );
    }
}

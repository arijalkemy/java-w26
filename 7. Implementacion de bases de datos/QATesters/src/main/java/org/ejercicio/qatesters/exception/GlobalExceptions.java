package org.ejercicio.qatesters.exception;

import org.ejercicio.qatesters.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException e) {
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()),HttpStatus.NOT_FOUND);
    }

}

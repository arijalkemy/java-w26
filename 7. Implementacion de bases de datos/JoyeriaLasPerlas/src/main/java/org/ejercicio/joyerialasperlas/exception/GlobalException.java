package org.ejercicio.joyerialasperlas.exception;

import org.ejercicio.joyerialasperlas.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException e) {
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()) ,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDto> badRequest(BadRequestException e) {
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()) ,HttpStatus.BAD_REQUEST);
    }
}

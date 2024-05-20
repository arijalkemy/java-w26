package com.mercadolibre.joyerialasperlas.exception;

import com.mercadolibre.joyerialasperlas.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = JewelNotFoundException.class)
    public ResponseEntity<ExceptionDTO> jewelNotFoundExceptionHandler(JewelNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionDTO(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}

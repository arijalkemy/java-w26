package com.mercadolibre.clothes.exception;

import com.mercadolibre.clothes.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ClothNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleClothNotFoundException(ClothNotFoundException e) {
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleSaleNotFoundException(SaleNotFoundException e) {
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DateConversionException.class)
    public ResponseEntity<ExceptionDTO> handleDateConversionException(DateConversionException e) {
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

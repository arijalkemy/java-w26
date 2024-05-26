package com.prendas.exceptions;

import com.prendas.DTOs.response.ExceptionDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler(PrendaNotFound.class)
    public ResponseEntity<ExceptionDetailsDTO> prendaNotFoundHandler(PrendaNotFound ex) {
        return new ResponseEntity<>(
                new ExceptionDetailsDTO(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

}

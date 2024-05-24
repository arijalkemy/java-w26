package org.example.productos.exceptions;

import org.example.productos.model.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<?> handleNotFoundException(NotFoundException exception){
        ErrorDTO error = new ErrorDTO(exception.getMessage());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
}

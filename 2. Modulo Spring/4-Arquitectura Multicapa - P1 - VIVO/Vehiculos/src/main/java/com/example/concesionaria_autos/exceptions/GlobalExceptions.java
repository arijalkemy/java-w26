package com.example.concesionaria_autos.exceptions;

import com.example.concesionaria_autos.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptions {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(String message){
        ExceptionDto exceptionDto = new ExceptionDto(message);
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}

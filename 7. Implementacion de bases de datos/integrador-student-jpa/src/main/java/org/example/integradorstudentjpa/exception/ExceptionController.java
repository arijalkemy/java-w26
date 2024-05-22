package org.example.integradorstudentjpa.exception;

import org.example.integradorstudentjpa.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException ex){
        ExceptionDTO exception = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(BadRequestException ex){
        ExceptionDTO exception = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> conflictException(BadRequestException ex){
        ExceptionDTO exception = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }


}

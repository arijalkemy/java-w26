package org.example.link_tracer.exception;

import org.example.link_tracer.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(WrongPasswordException.class)
    ResponseEntity<?> handleWrongPasswordException(WrongPasswordException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<?> handleNotFoundException(NotFoundException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadUrlException.class)
    ResponseEntity<?> handleBadUrlException(BadUrlException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DisabledUrlException.class)
    ResponseEntity<?> handleDisabledUrlException(DisabledUrlException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}

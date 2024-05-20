package com.bootcamp.joyeriacrud.exception;

import com.bootcamp.joyeriacrud.model.dto.MessageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> exceptionHandler(NotFoundException e) {
        return new ResponseEntity<>(new MessageResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}

package com.ejercicio.linktracker.exception;

import com.ejercicio.linktracker.DTO.MessageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<MessageResponseDTO> AlreadyExistException(AlreadyExistException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new MessageResponseDTO(e.getMessage())
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageResponseDTO> NotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new MessageResponseDTO(e.getMessage())
        );
    }
}

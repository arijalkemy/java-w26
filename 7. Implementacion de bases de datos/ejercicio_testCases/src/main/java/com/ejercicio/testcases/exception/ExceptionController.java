package com.ejercicio.testcases.exception;

import com.ejercicio.testcases.dto.ResponseMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseMessageDTO> notFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseMessageDTO(ex.getMessage())
        );
    }
}

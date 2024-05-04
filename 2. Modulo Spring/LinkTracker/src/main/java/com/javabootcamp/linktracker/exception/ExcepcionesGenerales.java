package com.javabootcamp.linktracker.exception;

import com.javabootcamp.linktracker.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExcepcionesGenerales {

    @ExceptionHandler(NotAuthorized.class)
    public ResponseEntity<ResponseDTO> notAuthorirized(Exception e)
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO(e.getMessage(),HttpStatus.UNAUTHORIZED.value()));
    }

    @ExceptionHandler(LinkRemoved.class)
    public ResponseEntity<ResponseDTO> linkRemoved(Exception e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(e.getMessage(),HttpStatus.NOT_FOUND.value()));
    }
}

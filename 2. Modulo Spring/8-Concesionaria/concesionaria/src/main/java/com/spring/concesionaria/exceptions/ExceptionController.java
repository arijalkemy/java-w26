package com.spring.concesionaria.exceptions;

import com.spring.concesionaria.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Bad Request",
                                                    HttpStatus.BAD_REQUEST.value(),
                                                    e.getMessage());
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<?> internalServerError(InternalServerError e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Internal Server Error",
                                                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                    e.getMessage());
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}

package com.implementacionDB.joyeria.exception;

import com.implementacionDB.joyeria.exception.dto.ExceptionDTO;
import com.implementacionDB.joyeria.exception.entity.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){
        ExceptionDTO message = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}

package com.example.joyeria.exception;

import com.example.joyeria.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException e){
        return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}

package com.example.ejercicios_dto_y_response_entityvivo_2.exception;

import com.example.ejercicios_dto_y_response_entityvivo_2.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage(),HttpStatus.NOT_FOUND.name());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}

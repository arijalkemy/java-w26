package org.meli.ejercicio4_testing_p3_1_starwars.exception;

import jakarta.validation.ConstraintViolationException;
import org.meli.ejercicio4_testing_p3_1_starwars.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerSW {


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDto> constraintViolationException(ConstraintViolationException ex, WebRequest webRequest) {
        System.out.println("constraintViolationException");
        ExceptionDto exdto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.BAD_REQUEST);
    }
}

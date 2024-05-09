package com.meli.obtenerdiploma.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;



@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomException> handleValidationException(MethodArgumentNotValidException ex){
        CustomException customException = new CustomException(ex.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<CustomException> handleValidationException(HttpMessageNotReadableException ex) {
        CustomException customException = new CustomException(ex.getMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);

    }
}

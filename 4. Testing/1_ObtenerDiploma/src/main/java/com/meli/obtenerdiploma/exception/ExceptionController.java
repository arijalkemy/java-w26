package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomException> handleValidationExceptions(MethodArgumentNotValidException ex){
        CustomException customException = new CustomException("Custom message: "+ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customException);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<CustomException> handleValidationExceptions(HttpMessageNotReadableException ex){
        CustomException customException = new CustomException("Custom message: "+ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customException);
    }

}

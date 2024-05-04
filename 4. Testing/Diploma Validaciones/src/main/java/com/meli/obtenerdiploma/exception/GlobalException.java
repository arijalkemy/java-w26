package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@ControllerAdvice (annotations = RestController.class)
public class GlobalException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (ObjectError error : ex.getAllErrors()) {
            errors.put(String.valueOf(
                    error.getCode()),
                    error.getDefaultMessage());
        }
        return new ResponseEntity<>(new ExceptionDTO(errors), HttpStatus.BAD_REQUEST);
    }


}

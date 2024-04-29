package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ListErrorsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ExceptionHandlerGlobal {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(e ->{


            errors.put(e.getField(),e.getDefaultMessage());

        });

        return ResponseEntity.badRequest().body(new ListErrorsDto(errors));
    }


}

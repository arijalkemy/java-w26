package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.MessageResponseDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity<MessageResponseDTO> handleValidationException(HttpMessageNotReadableException ex){
        return new ResponseEntity<>(new MessageResponseDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    protected ResponseEntity<List<String>> handleMethodValidationException(MethodArgumentNotValidException ex){
      List<String> errorList = ex.getBindingResult()
              .getFieldErrors()
              .stream()
              .map(DefaultMessageSourceResolvable::getDefaultMessage)
              .collect(Collectors.toList());
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}

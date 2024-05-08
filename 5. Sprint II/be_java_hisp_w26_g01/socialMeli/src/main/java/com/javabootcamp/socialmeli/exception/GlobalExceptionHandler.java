package com.javabootcamp.socialmeli.exception;

import com.javabootcamp.socialmeli.dto.response.ErrorDto;
import com.javabootcamp.socialmeli.dto.response.ResponseDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseDto> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(e.getMessage()));
    }
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ResponseDto> handleResponseStatusException(ResourceAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDto(e.getMessage()));
    }
    @ExceptionHandler(IllegalActionException.class)
    public ResponseEntity<ResponseDto> handleUnsupportedOperationException(IllegalActionException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(e.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<String> response = ex.getFieldErrors().stream().map(e ->
            e.getField()+": "+ e.getDefaultMessage()
        ).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto((response)));
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(HandlerMethodValidationException ex) {
        List<String> errors= ex.getAllErrors()
                                  .stream().map
                                  (e->e.getDefaultMessage()).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto((errors)));
    }

}

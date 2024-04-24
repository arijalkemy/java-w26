package com.bootcampW22.EjercicioGlobal.exception;

import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bootcampW22.EjercicioGlobal.dto.response.ExceptionResponse;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFound(NotFoundException e) {
        ExceptionResponse exceptionDto = new ExceptionResponse(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestMalFormedException.class)
    public ResponseEntity<ExceptionResponse> requestMalFormed(RequestMalFormedException e) {
        ExceptionResponse exceptionDto = new ExceptionResponse(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> notValidRequest(MethodArgumentNotValidException ex) {
        String message = ex.getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.joining(" | "));

        return ResponseEntity.badRequest().body(new ExceptionResponse(message));
    }

}

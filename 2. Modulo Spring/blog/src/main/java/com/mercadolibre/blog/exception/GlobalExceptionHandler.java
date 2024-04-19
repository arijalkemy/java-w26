package com.mercadolibre.blog.exception;

import com.mercadolibre.blog.dto.ResponseMessage;
import com.mercadolibre.blog.exception.custom.CreationException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(CreationException.class)
    public ResponseEntity<?> handleCreationException(CreationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body(new ResponseMessage("Error en el formato del body"));
    }
}

package com.mercadolibre.Empleados_NOSQL.exception;

import com.mercadolibre.Empleados_NOSQL.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNoContentException(NotFoundException ex) {
        ExceptionDto exdto = new ExceptionDto(ex.getMessage());
        return new ResponseEntity<>(exdto, HttpStatus.NOT_FOUND);
    }
}

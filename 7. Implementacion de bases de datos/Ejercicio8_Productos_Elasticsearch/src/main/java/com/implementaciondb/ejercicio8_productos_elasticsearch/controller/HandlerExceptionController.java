package com.implementaciondb.ejercicio8_productos_elasticsearch.controller;


import com.implementaciondb.ejercicio8_productos_elasticsearch.exception.NotFoundException;
import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handlerNoContentException(NotFoundException ex, WebRequest webRequest) {
        ExceptionDto exdto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.NOT_FOUND);
    }

}

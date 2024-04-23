package com.mercadolibre.LinkTracerAPI.exception;

import com.mercadolibre.LinkTracerAPI.dto.ExceptionMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LinkExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessageDTO> handlerNotFoundException(NotFoundException e){
        ExceptionMessageDTO exMessageDto = new ExceptionMessageDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exMessageDto);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionMessageDTO> handlerBadRequestException(BadRequestException e){
        ExceptionMessageDTO badRequestException = new ExceptionMessageDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestException);
    }
}

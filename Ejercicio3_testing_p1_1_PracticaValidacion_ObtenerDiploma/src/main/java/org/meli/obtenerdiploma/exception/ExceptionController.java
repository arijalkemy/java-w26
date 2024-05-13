package org.meli.obtenerdiploma.exception;

import org.meli.obtenerdiploma.dto.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomException> notFound(NotFoundException ex, WebRequest webRequest) {
        CustomException exdto = new CustomException(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CustomException> badRequest(BadRequestException ex, WebRequest webRequest) {
        CustomException exdto = new CustomException(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAcceptable.class)
    public ResponseEntity<CustomException> handlerNotAcceptable(NotAcceptable ex, WebRequest webRequest) {
        return new ResponseEntity<>(
                new CustomException(ex.getMessage(), webRequest.getDescription(false)),
                HttpStatus.NOT_ACCEPTABLE
        );
    }



}
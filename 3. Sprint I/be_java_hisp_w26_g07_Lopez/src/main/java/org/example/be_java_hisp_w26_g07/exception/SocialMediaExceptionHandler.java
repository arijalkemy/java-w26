package org.example.be_java_hisp_w26_g07.exception;

import org.example.be_java_hisp_w26_g07.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class SocialMediaExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException ex) {
        ExceptionDto exdto = new ExceptionDto(ex.getMessage());
        return new ResponseEntity<>(exdto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDto> badRequest(BadRequestException ex) {
        ExceptionDto exdto = new ExceptionDto(ex.getMessage());
        return new ResponseEntity<>(exdto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAcceptable.class)
    public ResponseEntity<ExceptionDto> handlerNotAcceptable(NotAcceptable ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handlerMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ExceptionDto exDto = new ExceptionDto("Los siguientes campos son obligatorios : " +
                String.join(", ", ex.getBindingResult().getFieldErrors().stream().map(FieldError::getField).toList()));
        return new ResponseEntity<>(exDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ExceptionDto> handlerMethodValidation(HandlerMethodValidationException ex) {
        ExceptionDto exDto = new ExceptionDto(ex.getMessage());
        return new ResponseEntity<>(exDto, HttpStatus.BAD_REQUEST);
    }
}

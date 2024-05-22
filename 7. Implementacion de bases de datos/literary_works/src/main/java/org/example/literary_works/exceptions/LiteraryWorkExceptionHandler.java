package org.example.literary_works.exceptions;

import org.example.literary_works.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class LiteraryWorkExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException ex, WebRequest webRequest) {
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDto> badRequest(BadRequestException ex, WebRequest webRequest) {
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}

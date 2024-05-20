package org.example.pearl_jewelry.exceptions;

import org.example.pearl_jewelry.dto.errors.ExceptionDto;
import org.example.pearl_jewelry.dto.errors.ValidationErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PearlJewelryExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDto> badRequest(BadRequestException ex, WebRequest webRequest) {
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), webRequest.getContextPath());
        return ResponseEntity.badRequest().body(exceptionDto);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException ex, WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), webRequest.getContextPath());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDto> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            WebRequest webRequest
    ) throws Exception {
        Map<String, String> errorTree = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> {
            errorTree.put(e.getField(), e.getDefaultMessage());
        });

        ValidationErrorDto errorDto = new ValidationErrorDto(errorTree, webRequest.getContextPath());

        return ResponseEntity.badRequest().body(errorDto);
    }
}

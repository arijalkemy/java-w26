package org.example.qa_tester.exceptions;

import org.example.qa_tester.dtos.exceptions.ExceptionDto;
import org.example.qa_tester.dtos.exceptions.ValidationErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class QaTesterExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDto> badRequest(BadRequestException ex, WebRequest webRequest) {
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return ResponseEntity.badRequest().body(exceptionDto);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException ex, WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
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

        ValidationErrorDto errorDto = new ValidationErrorDto(errorTree, webRequest.getDescription(false));

        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ValidationErrorDto> methodArgumentTypeMismatch(
            MethodArgumentNotValidException ex, WebRequest webRequest
    ) {
        Map<String, String> errorTree = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> {
            errorTree.put(e.getField(), e.getDefaultMessage());
        });
        ValidationErrorDto errorDto = new ValidationErrorDto(errorTree, webRequest.getDescription(false));
        return ResponseEntity.badRequest().body(errorDto);
    }
}

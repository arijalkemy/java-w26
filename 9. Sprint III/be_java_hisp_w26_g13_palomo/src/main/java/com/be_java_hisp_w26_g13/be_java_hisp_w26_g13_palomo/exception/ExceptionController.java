package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.exception;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.MessageDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        MessageDto messageDto = new MessageDto(e.getMessage());
        return new ResponseEntity<>(messageDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidOperation.class)
    public ResponseEntity<?> invalidOperation(InvalidOperation e){
        MessageDto messageDto = new MessageDto(e.getMessage());
        return new ResponseEntity<>(messageDto, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e) {
        MessageDto messageDto = new MessageDto(e.getMessage());
        return new ResponseEntity<>(messageDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectDateException.class)
    public ResponseEntity<?> incorrectDate(IncorrectDateException e){
        MessageDto messageDto = new MessageDto(e.getMessage());
        return new ResponseEntity<>(messageDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<MessageDto> handleValidationExceptions(ConstraintViolationException e) {
        MessageDto error = new MessageDto(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<FieldError> errorFields = e.getFieldErrors();

        Map<String, String> formattedErrors = new HashMap<>();
        for (FieldError field : errorFields) {
            formattedErrors.put(field.getField(), field.getDefaultMessage());
        }
        return new ResponseEntity<>(formattedErrors, HttpStatus.BAD_REQUEST);
    }
}

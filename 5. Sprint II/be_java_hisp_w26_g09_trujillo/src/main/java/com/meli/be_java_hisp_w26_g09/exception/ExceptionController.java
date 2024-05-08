package com.meli.be_java_hisp_w26_g09.exception;

import com.meli.be_java_hisp_w26_g09.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(NotContentFollowedException.class)
    public ResponseEntity<?> notContentFollowedException(NotContentFollowedException e) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> notSameTyping(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO("Not same typing attribute"));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDTO>> handleBadValidation(MethodArgumentNotValidException ex){
        List<ExceptionDTO> message = ex.getFieldErrors().stream()
                .map(ExceptionDTO::ofError)
                .toList();

        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDTO> httpMessageNotReadableException(HttpMessageNotReadableException ex){
        return ResponseEntity.badRequest().body(new ExceptionDTO("The format date is dd-MM-yyyy"));
    }
}

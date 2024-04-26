package com.meli.be_java_hisp_w26_g09.exception;

import com.meli.be_java_hisp_w26_g09.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
        return ResponseEntity.badRequest().body(new ExceptionDTO(
                "A data type is expected " + e.getParameter().getParameterType().getSimpleName() + "."));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(NullEntityException.class)
    public ResponseEntity<?> nullEntityException(NullEntityException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage()));
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> requestParamMethodArgumentResolver(MissingServletRequestParameterException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage()));
    }
}

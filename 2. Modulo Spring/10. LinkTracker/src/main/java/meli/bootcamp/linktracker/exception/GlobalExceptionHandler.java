package meli.bootcamp.linktracker.exception;

import meli.bootcamp.linktracker.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> unauthorizedException(UnauthorizedException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionDTO);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<?> forbiddenException(ForbiddenException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDTO);
    }
}

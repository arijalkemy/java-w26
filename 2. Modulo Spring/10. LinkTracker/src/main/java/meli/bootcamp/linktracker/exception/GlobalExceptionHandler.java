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

    @ExceptionHandler(NoPasswordException.class)
    public ResponseEntity<?> noPasswordException(NoPasswordException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(PasswordErrorException.class)
    public ResponseEntity<?> passwordErrorException(PasswordErrorException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(InactiveLinkException.class)
    public ResponseEntity<?> inactiveLinkException(InactiveLinkException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }
}

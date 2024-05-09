package org.example.SocialMeli2.exception;

import jakarta.validation.ConstraintViolationException;
import org.example.SocialMeli2.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

/**
 * Controlador de excepciones para manejar y responder a las excepciones lanzadas en la aplicación.
 */
@RestControllerAdvice
public class ExceptionController {

    /**
     * Maneja las excepciones de tipo NotFoundException.
     *
     * @param e La excepción lanzada.
     * @return Una respuesta HTTP con el mensaje de la excepción y el estado HTTP NOT_FOUND.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja las excepciones de tipo BadRequestException.
     *
     * @param e La excepción lanzada.
     * @return Una respuesta HTTP con el mensaje de la excepción y el estado HTTP BAD_REQUEST.
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja las excepciones de tipo MethodArgumentNotValidException.
     *
     * @param e La excepción lanzada.
     * @return Una respuesta HTTP con el mensaje de la excepción y el estado HTTP BAD_REQUEST.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ExceptionDTO exceptionDto = new ExceptionDTO(errorMessage);
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja las excepciones de tipo ConstraintViolationException.
     *
     * @param e La excepción lanzada.
     * @return Una respuesta HTTP con el mensaje de la excepción y el estado HTTP BAD_REQUEST.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException e) {
        String errorMessage = e.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));
        ExceptionDTO exceptionDto = new ExceptionDTO(errorMessage);
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja las excepciones de tipo HttpMessageNotReadableException.
     *
     * @param e La excepción lanzada.
     * @return Una respuesta HTTP con el mensaje de la excepción y el estado HTTP BAD_REQUEST.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO("Error al leer el cuerpo de la solicitud");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}

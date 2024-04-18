package com.EjercicioSpring.Ejercicio11_Excepciones.exception;

import com.EjercicioSpring.Ejercicio11_Excepciones.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(annotations = RestController.class)
public class BlogExceptionHandler {

    @ExceptionHandler(BlogExistenteException.class)
    public ResponseEntity<ErrorDTO> handlerBlogExistenteException(BlogExistenteException ex, WebRequest webRequest) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), webRequest.getDescription(false)); //false para que solo agregue la ruta y no todos los detalles
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }

    @ExceptionHandler(BlogInexistenteException.class)
    public ResponseEntity<ErrorDTO> handlerBlogInexistenteException(BlogInexistenteException ex, WebRequest webRequest) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), webRequest.getDescription(false)); //false para que solo agregue la ruta y no todos los detalles
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(SoloSeAceptanNumerosException.class)
    public ResponseEntity<ErrorDTO> handlerSoloSeAceptanNumerosException(SoloSeAceptanNumerosException ex, WebRequest webRequest) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), webRequest.getDescription(false)); //false para que solo agregue la ruta y no todos los detalles
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(TablaVaciaException.class)
    public ResponseEntity<ErrorDTO> handlerTablaVaciaException(TablaVaciaException ex, WebRequest webRequest) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), webRequest.getDescription(false)); //false para que solo agregue la ruta y no todos los detalles
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}

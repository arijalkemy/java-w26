package org.example.g14.exception;

import org.example.g14.dto.response.ErrorResponseDto;
import org.example.g14.dto.response.MessageResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(Exception e){
        return new ResponseEntity<>(new ErrorResponseDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(Exception e){
        return new ResponseEntity<>(new ErrorResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(Exception e) {
        return ResponseEntity.badRequest().body(
            new ErrorResponseDto("Hubo un error al leer algún parámetro de Path de la petición: " + e.getMessage())
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleBadRequestDeserializeException(){
        return new ResponseEntity<>(new ErrorResponseDto("Campos inválidos y/o faltantes."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> handleConflictException(Exception e){
        return new ResponseEntity<>(new ErrorResponseDto(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<String> detail = e.getFieldErrors().stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .toList();

        return ResponseEntity.badRequest().body(new MessageResponseDto(
            "Hubo algún error de validación en los datos pasados en en el cuerpo de la petición.",
            detail
        ));
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<MessageResponseDto> handleHandlerMethodValidationException(HandlerMethodValidationException e) {

        List<String> detail = new ArrayList<>();

        for (var result : e.getAllValidationResults()) {
            for (var error : result.getResolvableErrors()) {
                detail.add(
                    result.getMethodParameter().getParameterName()
                    + ": "
                    + error.getDefaultMessage()
                );
            }
        }

        return ResponseEntity.badRequest().body(new MessageResponseDto(
            "Hubo algún error de validación en algún parámetro de Path de la petición.",
            detail
        ));
    }

}

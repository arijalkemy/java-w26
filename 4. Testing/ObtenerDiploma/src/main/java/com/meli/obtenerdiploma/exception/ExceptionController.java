package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(buildMessage(ex)));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(buildMessage(ex)));
    }

    private String buildMessage(Exception ex) {
        String[] splitted = ex.getMessage().split("default message");
        return "Campo: " + splitted[1].trim().substring(0, splitted[1].length() - 4) + " inválido, mensaje: " + splitted[2].trim().substring(0, splitted[2].length() - 3) + ".";
    }
}

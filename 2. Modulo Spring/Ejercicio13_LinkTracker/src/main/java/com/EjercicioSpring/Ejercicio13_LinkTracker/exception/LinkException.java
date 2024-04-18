package com.EjercicioSpring.Ejercicio13_LinkTracker.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Data
public class LinkException extends RuntimeException{

    private HttpStatus status;

    public LinkException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}

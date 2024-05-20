package org.example.joyeria.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class JewelNotFound extends RuntimeException {
    private final HttpStatus status;

    public JewelNotFound(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}

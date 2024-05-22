package org.example.jpatesterqa.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundTestCase extends RuntimeException {
    private final HttpStatus status;

    public NotFoundTestCase(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}

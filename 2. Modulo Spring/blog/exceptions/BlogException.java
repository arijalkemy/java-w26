package org.example.blog.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BlogException extends RuntimeException {
    private HttpStatus status;

    public BlogException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }
}

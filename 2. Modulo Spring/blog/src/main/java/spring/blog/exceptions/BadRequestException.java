package spring.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BadRequestException  extends RuntimeException{

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}

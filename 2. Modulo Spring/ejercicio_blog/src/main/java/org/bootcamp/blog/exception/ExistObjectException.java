package org.bootcamp.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExistObjectException extends RuntimeException{

    public ExistObjectException(String message) {
        super(message);
    }
}

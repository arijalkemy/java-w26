package com.practicaSpring.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Id already exists for an entry on the blog")
public class DuplicateEntryIdException extends RuntimeException {
    public DuplicateEntryIdException() {
    }

    public DuplicateEntryIdException(String message) {
        super(message);
    }
}

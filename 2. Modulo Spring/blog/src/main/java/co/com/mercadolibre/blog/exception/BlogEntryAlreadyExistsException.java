package co.com.mercadolibre.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BlogEntryAlreadyExistsException extends RuntimeException {
    public BlogEntryAlreadyExistsException(String message) {
        super(message);
    }
}


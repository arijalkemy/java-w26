package co.com.mercadolibre.starwars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
public class DataTypeException extends Exception {

    private static final Long serialVersionUID = 1L;

    public DataTypeException(String message) {
        super(message);
    }
}

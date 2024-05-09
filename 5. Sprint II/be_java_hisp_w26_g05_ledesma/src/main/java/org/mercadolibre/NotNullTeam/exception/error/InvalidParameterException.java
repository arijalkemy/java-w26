package org.mercadolibre.NotNullTeam.exception.error;

public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException(String param) {
        super("Invalid param: " + param);
    }

}

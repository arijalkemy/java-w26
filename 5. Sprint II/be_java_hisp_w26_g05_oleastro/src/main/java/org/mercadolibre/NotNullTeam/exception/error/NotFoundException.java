package org.mercadolibre.NotNullTeam.exception.error;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("not found");
    }

    public NotFoundException(String entity) {
        super(entity + " not found");
    }
}

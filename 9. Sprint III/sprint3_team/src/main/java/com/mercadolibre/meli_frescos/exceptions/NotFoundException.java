package com.mercadolibre.meli_frescos.exceptions;


public class NotFoundException extends ApiException {

    public NotFoundException(String description) {
        super("Not found", description, 404);
    }
}

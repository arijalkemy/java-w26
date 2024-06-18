package com.mercadolibre.meli_frescos.exceptions;

public class BadRequestException extends ApiException {
    public BadRequestException(String description) {
        super("Bad Request", description, 400);
    }
}

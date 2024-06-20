package com.mercadolibre.pf_be_hisp_w26_t11_perez.exceptions;

public class BadRequestException extends ApiException {
    public BadRequestException(String description) {
        super("Bad Request", description, 400);
    }
}

package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.exceptions;


public class NotFoundException extends ApiException {

    public NotFoundException(String description) {
        super("Not found", description, 404);
    }
}


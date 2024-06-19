package com.mercadolibre.fresh_market.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFound extends ApiException {

    public EntityNotFound(String description) {
        super("Entity not found.", description, HttpStatus.NOT_FOUND.value());
    }
    
}

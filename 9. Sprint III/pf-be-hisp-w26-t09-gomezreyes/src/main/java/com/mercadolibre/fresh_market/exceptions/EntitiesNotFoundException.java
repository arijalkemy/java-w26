package com.mercadolibre.fresh_market.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class EntitiesNotFoundException extends ApiExceptionDetailed {

    public EntitiesNotFoundException(String description, Object detail) {
        super("Entities not found", description, HttpStatus.NOT_FOUND.value(), detail);
    }

}

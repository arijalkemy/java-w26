package com.mercadolibre.fresh_market.exceptions;

import org.springframework.http.HttpStatus;

public class InconsistentStockException extends ApiExceptionDetailed {

    public InconsistentStockException(String description, Object detail) {
        super("Error with Stock", description, HttpStatus.CONFLICT.value(), detail);
    }

}

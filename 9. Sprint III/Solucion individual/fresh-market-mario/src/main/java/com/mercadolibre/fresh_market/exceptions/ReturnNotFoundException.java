package com.mercadolibre.fresh_market.exceptions;

public class ReturnNotFoundException extends RuntimeException {
    public ReturnNotFoundException(String message) {
        super(message);
    }
}

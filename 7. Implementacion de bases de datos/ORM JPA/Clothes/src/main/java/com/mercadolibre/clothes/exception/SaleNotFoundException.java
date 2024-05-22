package com.mercadolibre.clothes.exception;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException() {
    }

    public SaleNotFoundException(String message) {
        super(message);
    }
}

package com.mercadolibre.clothes.exception;

public class ClothNotFoundException extends RuntimeException {
    public ClothNotFoundException() {
    }

    public ClothNotFoundException(String message) {
        super(message);
    }
}

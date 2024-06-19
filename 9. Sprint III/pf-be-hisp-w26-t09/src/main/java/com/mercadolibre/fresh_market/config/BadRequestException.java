package com.mercadolibre.fresh_market.config;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
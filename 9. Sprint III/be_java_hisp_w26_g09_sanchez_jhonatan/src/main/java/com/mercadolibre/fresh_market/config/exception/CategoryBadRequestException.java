package com.mercadolibre.fresh_market.config.exception;

public class CategoryBadRequestException extends RuntimeException{
    public CategoryBadRequestException(String message) {
        super(message);
    }
}

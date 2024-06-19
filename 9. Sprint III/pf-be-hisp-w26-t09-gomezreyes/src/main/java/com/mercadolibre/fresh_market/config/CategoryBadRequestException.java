package com.mercadolibre.fresh_market.config;

public class CategoryBadRequestException extends RuntimeException{
    public CategoryBadRequestException(String message) {
        super(message);
    }
}

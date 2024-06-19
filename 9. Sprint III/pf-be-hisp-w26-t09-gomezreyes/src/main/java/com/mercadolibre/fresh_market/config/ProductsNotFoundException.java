package com.mercadolibre.fresh_market.config;

public class ProductsNotFoundException extends RuntimeException{
    public ProductsNotFoundException(String message) {
        super(message);
    }
}

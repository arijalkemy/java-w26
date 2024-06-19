package com.mercadolibre.fresh_market.config;

public class ProductNotFoundException extends RuntimeException{

        public ProductNotFoundException(String message) {
            super(message);
        }
}

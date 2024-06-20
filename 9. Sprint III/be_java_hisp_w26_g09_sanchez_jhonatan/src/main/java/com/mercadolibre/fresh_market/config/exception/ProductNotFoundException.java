package com.mercadolibre.fresh_market.config.exception;

public class ProductNotFoundException extends RuntimeException{

        public ProductNotFoundException(String message) {
            super(message);
        }
}

package com.mercadolibre.fresh_market.config;

public class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(String message) {
            super(message);
        }
}

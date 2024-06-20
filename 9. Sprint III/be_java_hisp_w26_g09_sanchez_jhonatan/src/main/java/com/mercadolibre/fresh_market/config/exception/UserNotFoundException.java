package com.mercadolibre.fresh_market.config.exception;

public class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(String message) {
            super(message);
        }
}

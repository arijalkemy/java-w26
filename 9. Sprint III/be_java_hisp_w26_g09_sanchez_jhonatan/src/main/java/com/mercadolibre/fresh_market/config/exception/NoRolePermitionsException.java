package com.mercadolibre.fresh_market.config.exception;

public class NoRolePermitionsException extends RuntimeException
{
    public NoRolePermitionsException(String message) {
        super(message);
    }
}

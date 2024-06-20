package com.mercadolibre.fresh_market.config;

public class NoRolePermitionsException extends RuntimeException
{
    public NoRolePermitionsException(String message) {
        super(message);
    }
}

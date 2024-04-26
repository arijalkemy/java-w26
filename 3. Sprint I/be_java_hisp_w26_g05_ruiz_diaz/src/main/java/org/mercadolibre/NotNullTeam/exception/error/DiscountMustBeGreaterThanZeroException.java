package org.mercadolibre.NotNullTeam.exception.error;

public class DiscountMustBeGreaterThanZeroException extends RuntimeException{
    public DiscountMustBeGreaterThanZeroException(String message) {
        super(message);
    }
}

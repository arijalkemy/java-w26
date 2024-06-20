package com.mercadolibre.fresh_market.exceptions;

public class PurchaseOrderNotFoundException extends RuntimeException {

    public PurchaseOrderNotFoundException(String message) {
        super(message);
    }

    public PurchaseOrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

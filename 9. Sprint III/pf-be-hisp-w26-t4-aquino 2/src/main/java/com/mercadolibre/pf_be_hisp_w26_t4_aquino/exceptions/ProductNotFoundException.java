package com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

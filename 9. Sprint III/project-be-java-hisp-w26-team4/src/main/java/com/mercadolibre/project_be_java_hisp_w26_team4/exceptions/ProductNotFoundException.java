package com.mercadolibre.project_be_java_hisp_w26_team4.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

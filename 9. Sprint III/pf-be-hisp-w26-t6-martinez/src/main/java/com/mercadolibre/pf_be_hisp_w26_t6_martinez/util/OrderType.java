package com.mercadolibre.pf_be_hisp_w26_t6_martinez.util;

public enum OrderType {

    CARRITO("Carrito");

    private final String description;

    OrderType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

package com.mercadolibre.final_project_java_hisp_w26_t6.util;

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

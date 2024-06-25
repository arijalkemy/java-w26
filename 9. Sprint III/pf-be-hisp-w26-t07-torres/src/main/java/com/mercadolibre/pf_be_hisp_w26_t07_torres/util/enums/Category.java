package com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums;

public enum Category {
    FS("FRESCO"),
    RF("REFRIGERADO"),
    FF("CONGELADO");

    private final String text;

    Category(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

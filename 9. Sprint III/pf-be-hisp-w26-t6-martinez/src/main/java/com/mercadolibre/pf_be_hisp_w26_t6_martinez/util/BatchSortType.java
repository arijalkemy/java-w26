package com.mercadolibre.pf_be_hisp_w26_t6_martinez.util;

public enum BatchSortType {
    L("batch"), C("quantity"), F("due_date");

    private final String description;

    BatchSortType(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}

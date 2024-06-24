package com.mercadolibre.final_project_java_hisp_w26_t6.util;

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

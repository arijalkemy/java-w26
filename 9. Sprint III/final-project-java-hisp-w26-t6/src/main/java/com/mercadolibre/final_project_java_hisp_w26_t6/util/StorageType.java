package com.mercadolibre.final_project_java_hisp_w26_t6.util;

public enum StorageType {

    FS("Fresh"), RF("Refrigerated"), FF("Frozen");

    private final String description;

    StorageType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

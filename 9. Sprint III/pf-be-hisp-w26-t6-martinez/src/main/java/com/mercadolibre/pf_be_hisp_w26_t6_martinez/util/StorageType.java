package com.mercadolibre.pf_be_hisp_w26_t6_martinez.util;

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

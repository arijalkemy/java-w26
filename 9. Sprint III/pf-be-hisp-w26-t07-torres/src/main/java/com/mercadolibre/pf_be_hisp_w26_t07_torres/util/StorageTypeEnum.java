package com.mercadolibre.pf_be_hisp_w26_t07_torres.util;

public enum StorageTypeEnum {

    FS("Fresco"),
    RF("Refrigerado"),
    FF("Congelado");

    private String fullName;

    private StorageTypeEnum(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }


}

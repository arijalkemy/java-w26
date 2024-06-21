package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums;

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

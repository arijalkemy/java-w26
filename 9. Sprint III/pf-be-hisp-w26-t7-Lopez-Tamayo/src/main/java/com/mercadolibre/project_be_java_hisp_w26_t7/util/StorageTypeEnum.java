package com.mercadolibre.project_be_java_hisp_w26_t7.util;

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

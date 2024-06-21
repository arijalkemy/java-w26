package com.mercadolibre.project_be_java_hisp_w26_team5.enums;

import java.util.List;

public enum TypeProduct {
    FS("COOL"),
    RF("FRIDGE"),
    FF("FROZEN");

    private String value;

    TypeProduct(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<TypeProduct> valueOfList(List<String> category) {
        List<TypeProduct> types = null;
        for (String cat : category) {
            switch (cat) {
                case "FS":
                    types.add(TypeProduct.FS);
                    break;
                case "RF":
                    types.add(TypeProduct.RF);
                    break;
                case "FF":
                    types.add(TypeProduct.FF);
                    break;
            }
        }
        return types;
    }
}

package com.mercadolibre.final_project_java_hisp_w26_t1.enums;

import java.util.Map;

public class ProductCategory {

    
    private static final Map<String,String> PRODUCT_CATEGORIES = Map.of(
        "FS","Fresco",
        "RF","Refrigerado",
        "FF","Congelado"
    );

    private ProductCategory(){}

    public static String getCategory(String key){
        return PRODUCT_CATEGORIES.get(key);
    }
}
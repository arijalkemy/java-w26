package com.mercadolibre.final_project_java_hisp_w26_t1.utils;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Category;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Product;

public class ProductBuilder {

    private ProductBuilder(){}

    public static Product getProduct(){
        return Product.builder()
                .id(1)
                .name("Manzana")
                .category(new Category(1,"Fresco","Heladera"))
                .price(1.0)
                .build();
    }
}

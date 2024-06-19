package com.mercadolibre.pf_be_hisp_w26_t01_coro.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Product;

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

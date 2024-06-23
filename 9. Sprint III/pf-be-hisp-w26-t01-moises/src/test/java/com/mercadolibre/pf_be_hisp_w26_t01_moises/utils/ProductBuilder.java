package com.mercadolibre.pf_be_hisp_w26_t01_moises.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Product;

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
    public static Product getProduct(Double price){
        return Product.builder()
                .id(1)
                .name("Manzana")
                .category(new Category(1,"Fresco","Heladera"))
                .price(price)
                .build();
    }
}

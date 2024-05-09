package com.javabootcamp.socialmeli.utils;

import com.javabootcamp.socialmeli.model.Product;

public class ProductBuilder {

    public static Product product(){
        return new Product(
                1,
                "Camisa negra",
                "Camisa",
                "Adidas",
                "Negra",
                "Muy comoda"
        );
    }
}

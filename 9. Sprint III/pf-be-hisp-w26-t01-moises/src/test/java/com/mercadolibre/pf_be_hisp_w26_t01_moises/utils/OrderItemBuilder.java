package com.mercadolibre.pf_be_hisp_w26_t01_moises.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.OrderItem;

public class OrderItemBuilder {

    private OrderItemBuilder(){}

    public static OrderItem getOrderItem(){
        return OrderItem.builder()
                .id(1)
                .quantity(5)
                .product(ProductBuilder.getProduct())
                .build();
    }
    public static OrderItem getOrderItem(double price, int quantity){
        return OrderItem.builder()
                .id(1)
                .quantity(quantity)
                .product(ProductBuilder.getProduct(price))
                .build();
    }
}

package com.mercadolibre.pf_be_hisp_w26_t01_coro.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.OrderItem;

public class OrderItemBuilder {

    private OrderItemBuilder(){}

    public static OrderItem getOrderItem(){
        return OrderItem.builder()
                .id(1)
                .quantity(5)
                .product(ProductBuilder.getProduct())
                .build();
    }
}

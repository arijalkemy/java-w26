package com.mercadolibre.final_project_java_hisp_w26_t1.utils;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.OrderItem;

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

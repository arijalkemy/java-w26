package com.mercadolibre.pf_be_hisp_w26_t01_arguello.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.PurchaseOrder;

import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderBuilder {
    private PurchaseOrderBuilder(){}

    public static PurchaseOrder getPurchaseOrder(){
        return PurchaseOrder.builder()
                .id(1)
                .user(UserBuilder.getUser())
                .orderItems(List.of(OrderItemBuilder.getOrderItem()))
                .date(LocalDate.of(2024,1,1))
                .build();
    }
}

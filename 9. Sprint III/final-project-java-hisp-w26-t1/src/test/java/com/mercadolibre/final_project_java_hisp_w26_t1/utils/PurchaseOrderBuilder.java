package com.mercadolibre.final_project_java_hisp_w26_t1.utils;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.PurchaseOrder;

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

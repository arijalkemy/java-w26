package com.mercadolibre.pf_be_hisp_w26_t01_moises.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.PurchaseOrder;

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
    public static PurchaseOrder getPurchaseOrder(LocalDate date){
        return PurchaseOrder.builder()
                .id(1)
                .user(UserBuilder.getUser())
                .orderItems(List.of(OrderItemBuilder.getOrderItem()))
                .date(date)
                .build();
    }
    public static PurchaseOrder getPurchaseOrder(double price, int quantity){
        return PurchaseOrder.builder()
                .id(1)
                .user(UserBuilder.getUser())
                .orderItems(List.of(OrderItemBuilder.getOrderItem(price, quantity)))
                .date(LocalDate.of(2024,1,1))
                .build();
    }
    public static List<PurchaseOrder> getListWithDifferentDates() {
        return List.of(
                getPurchaseOrder(LocalDate.of(2024,1,11)),
                getPurchaseOrder(LocalDate.of(2023,5,12)),
                getPurchaseOrder(LocalDate.of(2025,2,13))
        );
    }
    public static List<PurchaseOrder> getListWithDifferentPrices() {
        return List.of(
                getPurchaseOrder(50.0,3),
                getPurchaseOrder(20.0,2),
                getPurchaseOrder(95.0,5)
        );
    }

}

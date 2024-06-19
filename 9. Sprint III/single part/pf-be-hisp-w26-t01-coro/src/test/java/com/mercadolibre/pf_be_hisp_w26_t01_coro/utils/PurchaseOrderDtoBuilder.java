package com.mercadolibre.pf_be_hisp_w26_t01_coro.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.OrderStatusDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.PurchaseOrderDTO;

import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderDtoBuilder {
    private PurchaseOrderDtoBuilder(){}

    public static PurchaseOrderDTO getPurchaseOrderDto(){
        return new PurchaseOrderDTO(
                LocalDate.of(2024,1,1),
                1,
                new OrderStatusDTO("CARRITO"),
                List.of(
                        new ProductPurchaseDTO(1,5)
                ));
    }
}

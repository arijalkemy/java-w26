package com.mercadolibre.final_project_java_hisp_w26_t1.utils;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.OrderStatusDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductPurchaseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.PurchaseOrderDTO;

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

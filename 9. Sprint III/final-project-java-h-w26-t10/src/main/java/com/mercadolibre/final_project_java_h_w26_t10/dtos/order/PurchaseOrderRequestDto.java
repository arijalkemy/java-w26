package com.mercadolibre.final_project_java_h_w26_t10.dtos.order;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderRequestDto {
    private String date;
    private Integer buyer_id;
    private PurchaseOrderStatusDto order_status;
    private List<PurchaseOrderProduct> products;
}

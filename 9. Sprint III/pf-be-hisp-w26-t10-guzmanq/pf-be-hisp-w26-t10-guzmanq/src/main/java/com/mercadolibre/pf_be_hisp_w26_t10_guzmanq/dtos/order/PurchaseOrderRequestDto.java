package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.order;

import lombok.*;

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

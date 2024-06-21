package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderResponseDto {
    private Double total_price;
}

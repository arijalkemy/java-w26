package com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDto {
    @JsonProperty("purchase_order")
    private PurchaseOrderDetailsDto details;
}

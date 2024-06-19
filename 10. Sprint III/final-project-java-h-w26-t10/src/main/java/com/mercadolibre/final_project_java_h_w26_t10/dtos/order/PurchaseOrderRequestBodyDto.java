package com.mercadolibre.final_project_java_h_w26_t10.dtos.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderRequestBodyDto {
    @JsonProperty("purchase_order")
    private PurchaseOrderRequestDto purchaseOrderRequestDto;
}

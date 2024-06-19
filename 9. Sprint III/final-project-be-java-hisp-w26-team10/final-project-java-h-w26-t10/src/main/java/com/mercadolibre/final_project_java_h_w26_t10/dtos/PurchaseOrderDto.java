package com.mercadolibre.final_project_java_h_w26_t10.dtos;

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


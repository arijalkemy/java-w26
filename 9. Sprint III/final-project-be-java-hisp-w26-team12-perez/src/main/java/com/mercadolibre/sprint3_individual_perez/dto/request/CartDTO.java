package com.mercadolibre.sprint3_individual_perez.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CartDTO {
    @NotNull
    @JsonProperty("purchase_order")
    private PurchaseOrderDTO purchaseOrder;

}

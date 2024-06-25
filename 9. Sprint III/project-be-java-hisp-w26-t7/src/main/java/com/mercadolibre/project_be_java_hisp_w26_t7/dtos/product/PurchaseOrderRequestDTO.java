package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderRequestDTO {

    @Valid
    @NotNull(message = "Purchase order details are required")
    @JsonProperty("purchase_order")
    private PurchaseOrderDetailsRequestDTO purchaseOrder;

}

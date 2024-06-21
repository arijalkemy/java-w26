package com.mercadolibre.project_be_java_hisp_w26_team5.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestPurchaseOrderDTO {
    @JsonProperty("product_id")
    @NotNull(message = "product_id cannot be null")
    private Integer productId;

    @JsonProperty("quantity")
    @NotNull(message = "quantity cannot be null")
    private Integer quantity;
}

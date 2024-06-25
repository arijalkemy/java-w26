package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPurchaseOrderRequestDto {

    @JsonProperty("product_id")
    @NotNull(message = "Product ID is required")
    @Positive(message = "Product ID must be positive")
    private Integer productId;

    @JsonProperty("quantity")
    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

}

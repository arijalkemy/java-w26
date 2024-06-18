package com.mercadolibre.meli_frescos.dto.frescos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasedProductDTO {
    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("quantity")
    private Integer quantity;
}

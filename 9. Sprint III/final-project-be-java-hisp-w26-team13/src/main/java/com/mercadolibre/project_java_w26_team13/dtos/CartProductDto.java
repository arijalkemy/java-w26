package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartProductDto {
    @JsonProperty("product_id")
    private long productId;
    private int quantity;
    @JsonProperty("cart_detail_id")
    private Long cartDetailId;
}

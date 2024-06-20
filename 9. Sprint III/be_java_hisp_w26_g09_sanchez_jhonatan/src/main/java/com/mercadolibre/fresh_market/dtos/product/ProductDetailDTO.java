package com.mercadolibre.fresh_market.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.fresh_market.model.enums.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDetailDTO {

    private Long id;
    @NotNull
    private Double price;
    @NotNull
    @JsonProperty("product_desc")
    private String description;
    private Long sellerId;

}

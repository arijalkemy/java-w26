package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.fresh_market.model.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDTO {
    private Long id;
    @NotBlank
    @PositiveOrZero
    private Double price;
    @NotEmpty
    @JsonProperty("product_desc")
    private String description;
}

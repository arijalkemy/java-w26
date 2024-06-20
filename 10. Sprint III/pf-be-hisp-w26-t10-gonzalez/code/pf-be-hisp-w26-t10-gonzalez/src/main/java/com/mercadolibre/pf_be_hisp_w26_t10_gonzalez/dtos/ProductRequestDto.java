package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    @JsonProperty("product_id")
    private Integer productId;
    private Integer quantity;
}

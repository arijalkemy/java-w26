package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderDTO {
    @JsonProperty("product_id")
    private ProductDTO product;
    private Integer quantity;
}

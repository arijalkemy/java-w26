package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.Product;
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

package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("seller_name")
    private String sellerName;

    @JsonProperty("category")
    private String category;
}

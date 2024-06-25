package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    @Positive
    private Double price;
    @NotEmpty(message = "Product must have a description")
    @JsonProperty("product_desc")
    private String description;
    @NotEmpty
    @JsonProperty("storage_type")
    private String storageType;
}

package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleProductErrorDto {
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("error_description")
    private String errorDescription;
}

package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.errors;

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

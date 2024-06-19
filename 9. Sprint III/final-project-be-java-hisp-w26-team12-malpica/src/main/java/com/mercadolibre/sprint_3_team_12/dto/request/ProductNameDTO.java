package com.mercadolibre.sprint_3_team_12.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductNameDTO {

    @NotNull
    @NotEmpty
    @JsonProperty("product_name")
    private String productName;

    @NotNull
    @NotEmpty
    @JsonProperty("price")
    private Double price;

}

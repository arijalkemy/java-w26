package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderTotalDTO {
    @JsonProperty("total_price")
    private Double totalPrice;

    @JsonProperty("errors")
    private List<ProductErrorDTO> errors;
}

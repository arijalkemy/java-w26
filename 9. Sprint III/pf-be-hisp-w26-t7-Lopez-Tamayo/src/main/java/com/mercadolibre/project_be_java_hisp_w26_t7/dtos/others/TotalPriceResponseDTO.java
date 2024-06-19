package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.errors.SimpleProductErrorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalPriceResponseDTO {
    @JsonProperty("total_price")
    private Double totalPrice;
    @JsonProperty("errors")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<SimpleProductErrorDto> productErrorDto;
}

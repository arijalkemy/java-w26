package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionAverageTemperature {
    @JsonProperty("average_temperature")
    private Double averageTemperature;
}

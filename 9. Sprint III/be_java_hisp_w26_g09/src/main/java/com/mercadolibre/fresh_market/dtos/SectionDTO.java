package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectionDTO {
    @JsonProperty("section_code")
    private Long sectionCode;
    @JsonProperty("warehouse_code")
    private Long warehouseCode;
}

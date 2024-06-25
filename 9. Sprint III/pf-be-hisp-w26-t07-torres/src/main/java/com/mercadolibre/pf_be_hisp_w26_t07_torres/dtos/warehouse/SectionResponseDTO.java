package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionResponseDTO {

    @JsonProperty("section_code")
    private Integer sectionCode;

    @JsonProperty("warehouse_code")
    private Integer warehouseCode;

}

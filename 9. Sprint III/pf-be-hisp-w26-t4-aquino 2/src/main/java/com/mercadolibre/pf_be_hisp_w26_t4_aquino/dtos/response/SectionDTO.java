package com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectionDTO {
    @JsonProperty("warehouse_code")
    Long warehouseId;

    @JsonProperty("section_code")
    Long sectionId;
}

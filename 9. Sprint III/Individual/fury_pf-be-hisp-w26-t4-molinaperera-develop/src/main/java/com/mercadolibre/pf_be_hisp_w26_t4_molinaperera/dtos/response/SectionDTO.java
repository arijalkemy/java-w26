package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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

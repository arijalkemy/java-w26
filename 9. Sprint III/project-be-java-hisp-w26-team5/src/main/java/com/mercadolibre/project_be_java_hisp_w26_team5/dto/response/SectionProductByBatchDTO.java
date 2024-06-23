package com.mercadolibre.project_be_java_hisp_w26_team5.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionProductByBatchDTO {
    @JsonProperty("section_code")
    private int sectionCode;
    @JsonProperty("warehouse_code")
    private int warehouseCode;
}
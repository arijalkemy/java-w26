package com.mercadolibre.project_java_w26_team13.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDto {
        @JsonProperty("section_code")
        private Long sectionCode;
        @JsonProperty("warehouse_code")
        private Long warehouseCode;
}

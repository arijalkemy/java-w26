package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionDto {

    @NotBlank(message = "section_code is required")
    @JsonProperty("section_code")
    Integer sectionCode;

    @NotBlank(message = "warehouse_code is required")
    @JsonProperty("warehouse_code")
    Integer warehouseCode;
}

package com.mercadolibre.sprint_3_team_12_malacara.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * USED IN REQUEST AND RESPONSE
 */
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class SectionDTO {
    @NotNull @NotEmpty @Positive
    @JsonProperty("section_code")
    private Integer sectionCode;

    @NotNull @NotEmpty @Positive
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;
}

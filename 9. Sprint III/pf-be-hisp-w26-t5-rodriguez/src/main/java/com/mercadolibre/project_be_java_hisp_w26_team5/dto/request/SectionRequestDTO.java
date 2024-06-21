package com.mercadolibre.project_be_java_hisp_w26_team5.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionRequestDTO {
    @NotNull(message = "Section code cannot be null")
    @JsonProperty("section_code")
    private Integer sectorId;

    @NotNull(message = "Warehouse code cannot be null")
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;
}

package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionRequestDTO {

    @JsonProperty("section_code")
    @NotNull(message = "Section code is required")
    @Positive(message = "Section code must be positive")
    private Long sectionCode;

    @JsonProperty("warehouse_code")
    @NotNull(message = "Warehouse code is required")
    @Positive(message = "Warehouse code must be positive")
    private Long warehouseCode;
}

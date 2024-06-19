package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SectionDTO {
    @NotNull(message = "Section code cannot be null")
    @Positive(message = "Section code must be positive")
    @JsonProperty("section_code")
    private Integer sectionCode;
    @NotNull(message = "Warehouse code cannot be null")
    @Positive(message = "Warehouse code must be positive")
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;
}

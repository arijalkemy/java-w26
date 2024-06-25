package com.mercadolibre.project_be_java_hisp_w26_team4.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class SectionDTO {
    @JsonProperty("section_code")
    @Min(value = 1)
    private Long id;
    @Min(value = 1)
    @JsonProperty("warehouse_code")
    private Long warehouseCode;
}

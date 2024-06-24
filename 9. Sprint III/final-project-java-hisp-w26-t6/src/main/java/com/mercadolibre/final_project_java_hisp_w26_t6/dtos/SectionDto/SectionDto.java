package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.SectionDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionDto implements Serializable {

    @NotNull(message = "El section_code no debe estar vacio")
    @JsonProperty("section_code")
    private Long sectionCode;

    @NotNull(message = "El warehouse_code no debe estar vacio")
    @Positive(message = "El warehouse_code no debe ser vacio")
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;
}

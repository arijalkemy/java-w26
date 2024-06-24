package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionDTO {
    @JsonProperty("section_code")
    private Long id;

    @JsonProperty("warehouse_code")
    private Long warehouse_id;
}

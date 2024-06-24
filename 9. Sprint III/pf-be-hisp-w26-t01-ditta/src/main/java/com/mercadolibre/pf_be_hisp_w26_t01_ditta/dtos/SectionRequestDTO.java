package com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SectionRequestDTO {
    @JsonProperty("idSection")
    private Integer idSection;
    @JsonProperty("idCategory")
    private Integer idCategory;
    @JsonProperty("maxBatchCapacity")
    private Integer maxBatchCapacity;
}


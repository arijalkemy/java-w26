package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.section;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionDto {
    private Long id;
    private String name;
    private Integer size;
}

package com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SectionDTO {
    Integer section_code;
    Integer warehouse_code;
}

package com.mercadolibre.pf_be_hisp_w26_t01_moises.util;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Section;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.SectionDTO
        ;
public class SectionMapper {
    public static SectionDTO toSectionDTO (Section section) {
        return SectionDTO.builder()
                .warehouse_code(section.getWarehouse().getId())
                .section_code(section.getId())
                .build();
    }
}

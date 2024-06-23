package com.mercadolibre.pf_be_hisp_w26_t01_arguello.util;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Section;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.SectionDTO
        ;
public class SectionMapper {
    public static SectionDTO toSectionDTO (Section section) {
        return SectionDTO.builder()
                .warehouse_code(section.getWarehouse().getId())
                .section_code(section.getId())
                .build();
    }
}

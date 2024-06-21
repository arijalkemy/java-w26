package com.mercadolibre.pf_be_hisp_w26_t1_cassini.util;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.SectionDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Section;
public class SectionMapper {
    public static SectionDTO toSectionDTO (Section section) {
        return SectionDTO.builder()
                .warehouse_code(section.getWarehouse().getId())
                .section_code(section.getId())
                .build();
    }
}

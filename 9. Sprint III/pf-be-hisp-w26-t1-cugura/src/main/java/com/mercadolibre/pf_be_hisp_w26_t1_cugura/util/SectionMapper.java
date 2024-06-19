package com.mercadolibre.pf_be_hisp_w26_t1_cugura.util;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Section;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.SectionDTO
        ;
public class SectionMapper {
    public static SectionDTO toSectionDTO (Section section) {
        return SectionDTO.builder()
                .warehouse_code(section.getWarehouse().getId())
                .section_code(section.getId())
                .build();
    }
}

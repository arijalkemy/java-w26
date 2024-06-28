package com.mercadolibre.project_be_java_hisp_w26_t7.mapper;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.section.SectionDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Section;

public class SectionMapper {
    public static Section responseDtoToEntity(SectionDto dto) {
        return Section.builder()
                .code(dto.getId())
                .size(dto.getSize())
                .build();
    }

    public static SectionDto entityToResponseDto(Section section) {
        return SectionDto.builder()
                .id(section.getCode())
                .size(section.getSize())
                .build();
    }
}

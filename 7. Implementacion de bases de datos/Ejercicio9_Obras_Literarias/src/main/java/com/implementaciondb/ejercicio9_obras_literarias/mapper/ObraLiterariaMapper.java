package com.implementaciondb.ejercicio9_obras_literarias.mapper;

import com.implementaciondb.ejercicio9_obras_literarias.model.domain.ObraLiteraria;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaRequestDto;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaResponseDto;

public class ObraLiterariaMapper {

    public static ObraLiteraria mapToObraLiteraria(ObraLiterariaRequestDto obraLiterariaRequestDto) {
        return ObraLiteraria.builder()
                .name(obraLiterariaRequestDto.getName())
                .author(obraLiterariaRequestDto.getAuthor())
                .numberPages(obraLiterariaRequestDto.getNumberPages())
                .editorial(obraLiterariaRequestDto.getEditorial())
                .yearPublication(obraLiterariaRequestDto.getYearPublication())
                .build();
    }

    public static ObraLiterariaResponseDto mapToObraLiterariaResponseDto(ObraLiteraria obraLiteraria) {
        return ObraLiterariaResponseDto.builder()
                .id(obraLiteraria.getId())
                .name(obraLiteraria.getName())
                .author(obraLiteraria.getAuthor())
                .numberPages(obraLiteraria.getNumberPages())
                .editorial(obraLiteraria.getEditorial())
                .yearPublication(obraLiteraria.getYearPublication())
                .build();
    }

}

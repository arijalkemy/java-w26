package jpa.ejercicioelasticsearch.mapper;

import jpa.ejercicioelasticsearch.dto.reponseDTO.ObraliterariaResponseDto;
import jpa.ejercicioelasticsearch.dto.requestDTO.ObraLiterariaRequestDto;
import jpa.ejercicioelasticsearch.model.ObraLiteraria;

public class ObraLiterariaMapper {

    public static ObraLiteraria mapToObraLiteraria(ObraLiterariaRequestDto obraLiteraria) {
        return  ObraLiteraria.builder()
                .name(obraLiteraria.getName())
                .author(obraLiteraria.getAuthor())
                .numberPages(obraLiteraria.getNumberPages())
                .editorial(obraLiteraria.getEditorial())
                .yearPublication(obraLiteraria.getYearPublication())
                .build();
    }

    public static ObraliterariaResponseDto mapToObraLiterariaResponseDto(ObraLiteraria obraLiteraria) {
        return  ObraliterariaResponseDto.builder()
                .id(obraLiteraria.getId())
                .name(obraLiteraria.getName())
                .author(obraLiteraria.getAuthor())
                .numberPages(obraLiteraria.getNumberPages())
                .editorial(obraLiteraria.getEditorial())
                .yearPublication(obraLiteraria.getYearPublication())
                .build();
    }

}

package com.implementaciondb.ejercicio9_obras_literarias.service;

import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaRequestDto;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaResponseDto;

import java.util.List;

public interface IObraLiterariaService {
    ObraLiterariaResponseDto saveObraLiteraria(ObraLiterariaRequestDto obraLiterariaRequestDto);
    List<ObraLiterariaResponseDto> searchAllObrasLiterarias();

    ObraLiterariaResponseDto searchObraLiterariaById(String id);

    ObraLiterariaResponseDto updateObraLiteraria(String id, ObraLiterariaRequestDto obraLiterariaRequestDto);

    List<ObraLiterariaResponseDto> searchObrasLiterariasByAuthor(String author);

    List<ObraLiterariaResponseDto> searchObrasLiterariasByTitleKeyword(String keyword);

    List<ObraLiterariaResponseDto> searchObrasLiterariasByPagesNumber();

    List<ObraLiterariaResponseDto> searchObrasLiterariasByYearPublicationBefore(Integer year);

    List<ObraLiterariaResponseDto> searchObrasLiterariasByEditorial(String editorial);
}

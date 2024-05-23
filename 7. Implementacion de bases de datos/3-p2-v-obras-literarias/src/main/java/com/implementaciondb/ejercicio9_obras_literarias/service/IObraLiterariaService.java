package com.implementaciondb.ejercicio9_obras_literarias.service;

import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaRequestDto;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IObraLiterariaService {
    ObraLiterariaResponseDto saveObraLiteraria(ObraLiterariaRequestDto obraLiteraria);

    ObraLiterariaResponseDto updateObraLiteraria(String id, ObraLiterariaRequestDto obraLiteraria);

    List<ObraLiterariaResponseDto> findAllObraLiterarias();

    ObraLiterariaResponseDto findObraLiterariaById(String id);

    List<ObraLiterariaResponseDto> findBooksByAuthor(String author);

    List<ObraLiterariaResponseDto> findBooksByKeyWordTitle(String keyWord);

    List<ObraLiterariaResponseDto> findBooksByNumberPages();

    List<ObraLiterariaResponseDto> findBooksByYearPublication(Integer yearPublication);
}

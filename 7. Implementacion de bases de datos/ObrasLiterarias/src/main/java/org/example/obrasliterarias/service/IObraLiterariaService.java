package org.example.obrasliterarias.service;

import org.example.obrasliterarias.dto.ObraLiterariaRequestDto;
import org.example.obrasliterarias.dto.ObraLiterariaResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IObraLiterariaService {
    List<ObraLiterariaResponseDto> saveBulk(List<ObraLiterariaRequestDto> obrasLiterias);

    List<ObraLiterariaResponseDto> findByAuthor(String author, Pageable pageable);

    List<ObraLiterariaResponseDto> getByTitleWildCard(String title, Pageable pageable);

    List<ObraLiterariaResponseDto> getTopByAmountPages(Pageable pageable);

    List<ObraLiterariaResponseDto> getByYearLess(Integer year, Pageable pageable);

    List<ObraLiterariaResponseDto> findByEditorial(String editorial, Pageable pageable);
}


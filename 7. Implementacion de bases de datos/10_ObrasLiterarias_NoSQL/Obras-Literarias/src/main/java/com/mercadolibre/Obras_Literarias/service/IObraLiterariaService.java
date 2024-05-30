package com.mercadolibre.Obras_Literarias.service;

import com.mercadolibre.Obras_Literarias.dto.ObraLiterariaDto;
import com.mercadolibre.Obras_Literarias.dto.ObraLiterariaResponseDto;

import java.util.List;

public interface IObraLiterariaService {
    ObraLiterariaResponseDto saveObra(ObraLiterariaDto obraLiterariaDto);

    List<ObraLiterariaResponseDto> getObrasByAutor(String autor);
    List<ObraLiterariaResponseDto> getObrasByTitulo(String keyWord);
    List<ObraLiterariaResponseDto> getObrasTop5QuantityPages();

    List<ObraLiterariaResponseDto>  getObrasBefore(int anio);

    List<ObraLiterariaResponseDto> getObrasByEditorial(String editorial);
}

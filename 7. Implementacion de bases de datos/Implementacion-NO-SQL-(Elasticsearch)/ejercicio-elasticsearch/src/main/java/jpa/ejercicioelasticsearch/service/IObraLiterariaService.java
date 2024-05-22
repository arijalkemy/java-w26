package jpa.ejercicioelasticsearch.service;


import jpa.ejercicioelasticsearch.dto.reponseDTO.ObraliterariaResponseDto;
import jpa.ejercicioelasticsearch.dto.requestDTO.ObraLiterariaRequestDto;

import java.util.List;

public interface IObraLiterariaService {
    ObraliterariaResponseDto saveObraLiteraria(ObraLiterariaRequestDto obraLiteraria);
    List<ObraliterariaResponseDto> saveAllObrasLiterarias(List<ObraLiterariaRequestDto> obrasLiterarias);
    List<ObraliterariaResponseDto> getAllByAuthor(String author);
    List<ObraliterariaResponseDto> getAllObrasByKeyWordTitle(String keyWord);
    List<ObraliterariaResponseDto> getTopFiveObrasLiterariasByNumberPage();
    List<ObraliterariaResponseDto> getObrasLiterariasByYearPublicationBefore(int year);
    List<ObraliterariaResponseDto> getObrasLiterariasByEditorial(String editorial);
}

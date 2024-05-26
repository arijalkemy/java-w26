package org.responseentity.elasticspring.service;

import org.responseentity.elasticspring.dto.ObraLiterariaDTO;

import java.util.List;

public interface IObraLiterariaService {
    List<ObraLiterariaDTO> findAllByAuthor(String autor);
    List<ObraLiterariaDTO> findKeywordInTitle(String nombre);
    List<ObraLiterariaDTO> findTopFivePages();
    List<ObraLiterariaDTO> findPreviousYear(Integer year);
    List<ObraLiterariaDTO> findAllByEditorial(String editorial);
}

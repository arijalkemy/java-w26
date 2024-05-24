package org.example.obras_literalias.services;

import org.example.obras_literalias.DTO.ObraLiterariaDTO;
import java.util.List;

public interface IObraService {
    List<ObraLiterariaDTO> findByAuthor(String author);
    List<ObraLiterariaDTO> findByTitleKeyword(String keyword);
    List<ObraLiterariaDTO> findTopFiveWithMoreAmountPages();
    List<ObraLiterariaDTO> findAllPublishedBeforeYear(Integer year);
    List<ObraLiterariaDTO> findAllByEditorial(String editorial);
}

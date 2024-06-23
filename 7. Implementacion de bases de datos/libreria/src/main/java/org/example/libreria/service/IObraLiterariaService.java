package org.example.libreria.service;

import org.example.libreria.dto.ObraLiterariaRequestDTO;
import org.example.libreria.dto.ObraLiterariaResponseDTO;
import org.example.libreria.entity.ObraLiteraria;

import java.util.List;

public interface IObraLiterariaService {

    void saveObraLiteraria(ObraLiterariaRequestDTO obraLiteraria);
    void saveObrasLiterarias(List<ObraLiterariaRequestDTO> obraLiteraria);
    List<ObraLiterariaResponseDTO> getObrasLiterariasByAutor(String autor);
    List<ObraLiterariaResponseDTO> getObrasLiterariasByNombre(String nombre);
    List<ObraLiterariaResponseDTO> getObrasLiterariasTopOrderPages();
    List<ObraLiterariaResponseDTO> getObrasLiterariasBeforYearPublication(Integer year);
    List<ObraLiterariaResponseDTO> getObrasLiterariasByEditorial(String editorial);
}

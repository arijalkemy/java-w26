package org.example.obrasliterarias.service;

import org.example.obrasliterarias.model.dto.ObraRequestDTO;
import org.example.obrasliterarias.model.dto.ObraResponseDTO;

import java.util.List;

public interface IObraService {
    ObraResponseDTO create(ObraRequestDTO obra);
    List<ObraResponseDTO> bulk(List<ObraRequestDTO> obrasDTO);
    List<ObraResponseDTO> findObraByAutor(String autor);
    List<ObraResponseDTO> findObraByTitle(String titulo);
    List<ObraResponseDTO> findObraByPaginas();
    List<ObraResponseDTO> findObraByAnioPublicacion(Integer anio);
    List<ObraResponseDTO> findObraByEditorial(String editorial);
}

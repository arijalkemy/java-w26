package org.example.obrasliterarias.service;

import org.example.obrasliterarias.dto.ObraDto;

import java.util.List;

public interface IObraService {
    List<ObraDto> findByAutor(String autor);

    List<ObraDto> findObraByName(String name);

    List<ObraDto> findAll();

    List<ObraDto> findTopFivePagesObra();

    List<ObraDto> findObrasBeforeYear(Integer year);

    List<ObraDto> findObraByEditorial(String editorial);

    void save(ObraDto libro);

}

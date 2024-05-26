package com.prendas.services;


import com.prendas.DTOs.request.PrendaRequestDTO;
import com.prendas.DTOs.response.PrendaResponseDTO;

import java.util.List;

public interface IPrendaService {
    PrendaResponseDTO crear(PrendaRequestDTO prendaDTO);
    List<PrendaResponseDTO> getAll();
    List<PrendaResponseDTO> findByName(String nombre);
    PrendaResponseDTO findByCode(Long code);
    PrendaResponseDTO update(Long id, PrendaRequestDTO prendaDTO);
    void delete(Long code);
    List<PrendaResponseDTO> findBySize(String size);
}

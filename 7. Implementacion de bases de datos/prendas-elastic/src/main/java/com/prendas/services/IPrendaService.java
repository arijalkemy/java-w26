package com.prendas.services;


import com.prendas.DTOs.request.PrendaRequestDTO;
import com.prendas.DTOs.response.PrendaResponseDTO;

import java.util.List;

public interface IPrendaService {
    PrendaResponseDTO crear(PrendaRequestDTO prendaDTO);
    List<PrendaResponseDTO> getAll();
    List<PrendaResponseDTO> findByName(String nombre);
    PrendaResponseDTO findByCode(String code);
    PrendaResponseDTO update(String id, PrendaRequestDTO prendaDTO);
    void delete(String code);
    List<PrendaResponseDTO> findBySize(String size);
}

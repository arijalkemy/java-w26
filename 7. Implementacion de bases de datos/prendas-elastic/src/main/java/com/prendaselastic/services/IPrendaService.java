package com.prendaselastic.services;


import com.prendaselastic.DTOs.request.PrendaRequestDTO;
import com.prendaselastic.DTOs.response.PrendaResponseDTO;

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

package com.demospring.calculadoradecalorias.service;

import com.demospring.calculadoradecalorias.dto.PlatoRequestDTO;
import com.demospring.calculadoradecalorias.dto.PlatoResponseDTO;

import java.util.List;

public interface IRestaurante {
    PlatoResponseDTO getCaloriasPlato(PlatoRequestDTO platoRequestDTO);
    List<PlatoResponseDTO> getCaloriasPlatos(List<PlatoRequestDTO> platos);
}

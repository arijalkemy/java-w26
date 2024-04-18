package com.calculadora.calorias.service;


import com.calculadora.calorias.dto.PlatoInputDTO;
import com.calculadora.calorias.dto.PlatoResponseDTO;

import java.util.List;

public interface CaloriasService {

    List<PlatoResponseDTO> calcularTotalCalorias(List<PlatoInputDTO> platoInputDTO);

    PlatoResponseDTO calcularCalorias(PlatoInputDTO platoInputDTO);
}

package com.asinc_ejerciciocalculadoracalorias.servicio;

import com.asinc_ejerciciocalculadoracalorias.dto.PlatoRequestDTO;
import com.asinc_ejerciciocalculadoracalorias.dto.PlatoResponseDTO;

import java.util.List;

public interface IPlatoServicio {
    PlatoResponseDTO calcularCalorias(PlatoRequestDTO plato);

    List<PlatoResponseDTO> calcularCalorias(List<PlatoRequestDTO> platos);
}

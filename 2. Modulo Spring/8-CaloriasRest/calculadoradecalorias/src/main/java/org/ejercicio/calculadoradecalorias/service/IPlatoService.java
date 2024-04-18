package org.ejercicio.calculadoradecalorias.service;

import org.ejercicio.calculadoradecalorias.dto.PlatoDTO;
import org.ejercicio.calculadoradecalorias.dto.PlatoResponseDTO;

public interface IPlatoService {
    PlatoResponseDTO informacionPlato(PlatoDTO platoDTO);
}

package com.spring.calculadoracalorias.service.interfaces;

import com.spring.calculadoracalorias.dto.PlatoDTO;
import com.spring.calculadoracalorias.dto.PlatoRequestDTO;
import com.spring.calculadoracalorias.entity.Plato;

import java.util.List;

public interface IPlatoService {
    List<PlatoDTO> getListOfPlatosByNameAndPeso(List<PlatoRequestDTO> listPlatos);

    PlatoDTO getPlatoByNameAndPeso(String name, double peso);
}

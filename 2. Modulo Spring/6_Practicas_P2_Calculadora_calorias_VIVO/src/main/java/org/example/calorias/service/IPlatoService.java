package org.example.calorias.service;

import org.example.calorias.dto.PlatoConPesoRequestDTO;
import org.example.calorias.dto.PlatoConPesoResponseDTO;
import org.example.calorias.dto.PlatoDTO;

import java.util.List;
import java.util.Optional;

public interface IPlatoService {
    List<PlatoDTO> buscarTodos();
    Optional<PlatoConPesoResponseDTO> buscarPorNombreConPeso(String nombre, int peso);
    List<PlatoConPesoResponseDTO> buscarEnLote(List<PlatoConPesoRequestDTO> platos);
}

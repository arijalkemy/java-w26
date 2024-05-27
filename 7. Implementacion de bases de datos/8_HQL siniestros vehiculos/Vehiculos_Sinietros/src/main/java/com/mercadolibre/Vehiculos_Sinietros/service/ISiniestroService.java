package com.mercadolibre.Vehiculos_Sinietros.service;

import com.mercadolibre.Vehiculos_Sinietros.model.dto.SiniestroRequestDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.SiniestroResponseDto;

import java.util.List;

public interface ISiniestroService {
    public SiniestroResponseDto saveSiniestro(SiniestroRequestDto siniestro);
    public List<SiniestroResponseDto> getAllSiniestro();
    public SiniestroResponseDto getSiniestroById(Long id);
}

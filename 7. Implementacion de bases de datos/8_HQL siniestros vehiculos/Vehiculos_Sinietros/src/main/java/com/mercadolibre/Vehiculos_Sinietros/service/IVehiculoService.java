package com.mercadolibre.Vehiculos_Sinietros.service;

import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoRequestDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoResponseDto;

import java.util.List;

public interface IVehiculoService {
    public VehiculoResponseDto saveVehiculo(VehiculoRequestDto siniestro);
    public List<VehiculoResponseDto> getAllVehiculo();
    public VehiculoResponseDto getVehiculoById(Long id);
}

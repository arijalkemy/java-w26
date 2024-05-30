package com.mercadolibre.Vehiculos_Sinietros.service;

import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoRequestDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoResponseDto;
import com.mercadolibre.Vehiculos_Sinietros.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoService {
    public VehiculoResponseDto saveVehiculo(VehiculoRequestDto siniestro);
    public List<VehiculoResponseDto> getAllVehiculo();
    public VehiculoResponseDto getVehiculoById(Long id);
    List<VehiculoResponseDto> findPatentAllVehicle();
    List<VehiculoResponseDto> findPatentAndBrandAllVehicleOrderByYearManufacture();
    List<VehiculoResponseDto> findPatentAllVehicleWithFourWheelsAndManufactureCurrentYear();
    List<VehiculoResponseDto> findAllVehicleWithCrashOver10000();
    List<VehiculoResponseDto> findAllVehicleWithCrashOver10000AndTotalLoss();
}

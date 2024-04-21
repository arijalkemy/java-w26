package com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.service;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.ResponseDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.VehicleDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.VehicleWithServicesDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    public List<VehicleDto> searchVehicles();
    public VehicleWithServicesDto searchVehicleById(int id);
    public ResponseDto createVehicle(VehicleWithServicesDto vehicleWithServicesDto);
    public List<VehicleDto> searchVehiclesByManufacturingDate(int since, int to);
    public List<VehicleDto> searchVehiclesByPrice(int min, int max);
}

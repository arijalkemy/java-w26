package org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.service.Interface;

import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.dto.VehicleRequestDTO;

import java.util.List;

public interface IVehicleService {
    VehicleRequestDTO addVehicle(VehicleRequestDTO vehicle);
    List<VehicleRequestDTO> getAllUsedVehicles();
    List<VehicleRequestDTO> getVehiclesByManufacturingDate(String date);
    List<VehicleRequestDTO> getVehiclesByPrices(double price);
    VehicleRequestDTO getVehicleById(Long id);
}

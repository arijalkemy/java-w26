package org.implementaciondb.ejercicio6_vehiculos_siniestros.service.interfaces;

import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.VehicleRequestDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.VehicleResponseDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.VehicleWithSinistersDto;

import java.util.List;

public interface IVehicleService {
    VehicleResponseDto saveVehicle(VehicleRequestDto vehicleRequestDto);

    List<VehicleWithSinistersDto> findAllVehicles();

    VehicleWithSinistersDto findVehicleById(Long id);

    List<?> getAllPatents();

    List<?> findPatentAndBrand();

    /*List<?> findAllPatentsByNumberOfWheelsAndManufacturedYear();*/

    List<?> findByEconomicLoss();

    List<?> findByEconomicLossDetails();
}

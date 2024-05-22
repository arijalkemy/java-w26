package org.implementaciondb.ejercicio6_vehiculos_siniestros.service.interfaces;

import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.*;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PartialVehicleAndEconomicLoss;

import java.util.List;

public interface IVehicleService {
    VehicleResponseDto saveVehicle(VehicleRequestDto vehicleRequestDto);

    List<VehicleWithSinistersDto> findAllVehicles();

    VehicleWithSinistersDto findVehicleById(Long id);

    List<PatentDto> getAllPatents();

    List<PatentAndBrandDto> findPatentAndBrand();

    List<PatentDto> findAllPatentsByNumberOfWheelsAndManufacturedYear();

    List<PartialVehicleDto> findByEconomicLoss();

    List<PartialVehicleAndEconomicLossDto> findByEconomicLossDetails();
}

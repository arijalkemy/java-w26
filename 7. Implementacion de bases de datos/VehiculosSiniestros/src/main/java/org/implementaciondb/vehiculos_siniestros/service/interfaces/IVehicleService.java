package org.implementaciondb.vehiculos_siniestros.service.interfaces;

import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.*;

import java.util.List;

public interface IVehicleService {
    VehicleResponseDto saveVehicle(VehicleRequestDto vehicleRequestDto);

    List<VehicleWithSinistersDto> findAllVehicles();

    VehicleWithSinistersDto findVehicleById(Long id);

    List<String> getAllPatents();

    List<VehicleQueriesDTO> findPatentAndBrand();

    List<String> findAllPatentsByNumberOfWheelsAndManufacturedYear();

    List<VehicleQueriesDTO> getLostMoreThan10000();

    VehiclesSinistersWithTotalLossDTO getEconomicLossDetails();

}

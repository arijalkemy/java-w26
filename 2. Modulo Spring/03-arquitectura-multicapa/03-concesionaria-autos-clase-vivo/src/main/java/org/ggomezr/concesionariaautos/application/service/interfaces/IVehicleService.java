package org.ggomezr.concesionariaautos.application.service.interfaces;

import org.ggomezr.concesionariaautos.domain.dto.VehicleInputDTO;
import org.ggomezr.concesionariaautos.domain.dto.VehicleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    VehicleInputDTO createVehicle(VehicleInputDTO vehicleInputDTO);

    List<VehicleResponseDTO> getAllVehicles();

    List<VehicleResponseDTO> getVehiclesByManufacturingDate(LocalDate sinceDate, LocalDate toDate);

    List<VehicleResponseDTO> getVehiclesByPriceRange(Integer since, Integer to);

    VehicleResponseDTO getVehicleById(Integer id);
}

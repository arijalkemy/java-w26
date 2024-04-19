package org.responseentity.agenciaautos.service;

import org.responseentity.agenciaautos.dto.VehicleDTOWithServices;
import org.responseentity.agenciaautos.dto.VehicleDTOWithoutServices;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface VehicleService {
    List<VehicleDTOWithoutServices> getAllVehicles();
    VehicleDTOWithServices getVehicleById(UUID id);
    List<VehicleDTOWithoutServices> getVehiclesByPriceRange(int priceLowRange, int priceHighRange);
    List<VehicleDTOWithoutServices> getVehiclesByDateRange(LocalDate dateLowRange, LocalDate dateHighRange);
    VehicleDTOWithServices addVehicle(VehicleDTOWithServices vehicleEntity);
}

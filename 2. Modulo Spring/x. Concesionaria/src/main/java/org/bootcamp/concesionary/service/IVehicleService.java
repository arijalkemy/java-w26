package org.bootcamp.concesionary.service;

import org.bootcamp.concesionary.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDTO> getAllVehicles();
    VehicleDTO getVehicleByIndex(String index);
    void addVehicle(VehicleDTO vehicle);
    List<VehicleDTO> filterVehiclesByManufacturingDateRange(String startDate, String endDate);
    List<VehicleDTO> filterVehiclesByPriceRange(Integer startPrice, Integer endPrice);
}

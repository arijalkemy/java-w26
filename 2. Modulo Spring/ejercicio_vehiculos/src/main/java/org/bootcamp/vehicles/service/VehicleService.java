package org.bootcamp.vehicles.service;

import org.bootcamp.vehicles.dto.VehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface VehicleService {

    VehicleDTO save(VehicleDTO vehicleDTO);

    List<VehicleDTO> getAll();

    List<VehicleDTO> getVehiclesByManufacturingDate(LocalDate sinceDate, LocalDate toDate);

    List<VehicleDTO> getVehiclesBetweenPrice(Double sincePrice, Double toPrice);

    VehicleDTO getVehicleById(Integer idVehicle);

}

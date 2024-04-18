package org.ggomezr.concesionariaautos.application.service.interfaces;

import org.ggomezr.concesionariaautos.domain.dto.VehicleDTO;
import org.ggomezr.concesionariaautos.domain.entity.Vehicle;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    Vehicle createVehicle(Vehicle vehicle);
    List<VehicleDTO> getAllVehicles();
    List<VehicleDTO> getVehiclesByManufacturingDate(LocalDate sinceDate, LocalDate toDate);
    List<VehicleDTO> getVehiclesByPriceRange(Integer priceSince, Integer priceTo);
    VehicleDTO getVehicleById(Integer id);
}

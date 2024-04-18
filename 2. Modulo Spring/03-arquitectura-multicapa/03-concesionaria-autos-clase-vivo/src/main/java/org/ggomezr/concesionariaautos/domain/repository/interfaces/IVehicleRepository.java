package org.ggomezr.concesionariaautos.domain.repository.interfaces;

import org.ggomezr.concesionariaautos.domain.dto.VehicleDTO;
import org.ggomezr.concesionariaautos.domain.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    Vehicle createVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}

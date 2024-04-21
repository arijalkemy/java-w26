package org.ggomezr.concesionariaautos.domain.repository.interfaces;

import org.ggomezr.concesionariaautos.domain.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    Vehicle saveVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}

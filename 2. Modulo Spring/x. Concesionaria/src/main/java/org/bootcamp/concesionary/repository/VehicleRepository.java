package org.bootcamp.concesionary.repository;

import org.bootcamp.concesionary.model.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleRepository {
    public List<Vehicle> getAllVehicles();
    public Vehicle getVehicleByIndex(UUID index);
}

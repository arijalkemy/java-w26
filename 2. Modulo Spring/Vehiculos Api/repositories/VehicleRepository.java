package org.example.vehicles.repositories;

import org.example.vehicles.entities.Vehicle;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class VehicleRepository {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void saveVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}

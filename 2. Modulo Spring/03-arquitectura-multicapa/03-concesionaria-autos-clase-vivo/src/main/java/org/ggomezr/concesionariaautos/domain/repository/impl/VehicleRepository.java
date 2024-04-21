package org.ggomezr.concesionariaautos.domain.repository.impl;

import org.ggomezr.concesionariaautos.domain.dto.VehicleResponseDTO;
import org.ggomezr.concesionariaautos.domain.entity.Vehicle;
import org.ggomezr.concesionariaautos.domain.repository.interfaces.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}

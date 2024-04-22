package com.example.concesionaria_autos.repository.VehicleRepository.impl;

import com.example.concesionaria_autos.entities.Vehicle;
import com.example.concesionaria_autos.repository.VehicleRepository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public UUID save(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle.getId();
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public Vehicle findById(UUID id) {
        return vehicles.stream().filter( v -> v.getId().equals(id)).findFirst().orElse(null);
    }

}

package com.example.concesionaria.repository.VehicleRepository.impl;

import com.example.concesionaria.entities.Vehicle;
import com.example.concesionaria.repository.VehicleRepository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void save(Vehicle vehicle) {
        vehicle.setId(UUID.randomUUID());
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> findAllByDate(LocalDate since, LocalDate to) {
        return vehicles.stream().filter(v -> {
            LocalDate vehicleManufacturingDate = LocalDate.parse(v.getManufacturingDate());
            return !vehicleManufacturingDate.isBefore(since) && !vehicleManufacturingDate.isAfter(to);
        }).toList();
    }

    @Override
    public List<Vehicle> findAllByPrice(Double since, Double to) {
        return vehicles.stream().filter(v -> v.getPrice() >= since && v.getPrice() <= to).toList();
    }

    @Override
    public Optional<Vehicle> findById(UUID id) {
        return vehicles.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

}

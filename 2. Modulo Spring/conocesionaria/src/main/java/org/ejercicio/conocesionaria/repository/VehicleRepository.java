package org.ejercicio.conocesionaria.repository;

import org.ejercicio.conocesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Repository
public class VehicleRepository implements IVehicleRepository {

    Map<UUID, Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new HashMap<>();
    }

    @Override
    public Vehicle findById(UUID id) {
        return vehicles.get(id);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles.values().stream().toList();
    }

    @Override
    public List<Vehicle> getAllVehiclesByDate(LocalDate since, LocalDate to) {
        return vehicles.values().stream().filter(v-> v.getManufacturingDate().isAfter(since) &&
                v.getManufacturingDate().isBefore(to)).toList();
    }

    @Override
    public List<Vehicle> getAllVehiclesByPrices(double since, double to) {
        return vehicles.values().stream().filter(v-> v.getPrice() >= since &&
                v.getPrice() <= to).toList();
    }

    @Override
    public Vehicle getAllVehiclesById(UUID id) {
        return vehicles.get(id);
    }

    @Override
    public List<Vehicle> getAllVehiclesByOwners() {
        return vehicles.values().stream().filter(v->v.getCountOfOwners() > 0).toList();
    }
}

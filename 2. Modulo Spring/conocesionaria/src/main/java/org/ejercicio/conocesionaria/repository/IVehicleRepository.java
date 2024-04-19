package org.ejercicio.conocesionaria.repository;

import org.ejercicio.conocesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface IVehicleRepository {
    Vehicle findById(UUID id);
    Vehicle save(Vehicle vehicle);
    List<Vehicle> findAll();
    List<Vehicle> getAllVehiclesByDate(LocalDate since, LocalDate to);
    List<Vehicle> getAllVehiclesByPrices(double since,double to);
    Vehicle getAllVehiclesById( UUID id);
    List<Vehicle> getAllVehiclesByOwners();
}

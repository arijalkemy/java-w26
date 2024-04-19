package org.example.concesionaria.repository;

import org.example.concesionaria.model.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Optional<Vehicle> findById(UUID id);

    Vehicle create(Vehicle vehicle);

    List<Vehicle> findByManufacturingDate(LocalDate since, LocalDate to);

    List<Vehicle> findByPrice(Integer since, Integer to);
}

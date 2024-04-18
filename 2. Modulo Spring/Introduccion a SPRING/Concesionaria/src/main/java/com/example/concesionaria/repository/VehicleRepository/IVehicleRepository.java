package com.example.concesionaria.repository.VehicleRepository;

import com.example.concesionaria.entities.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVehicleRepository {
    void save(Vehicle vehicle);
    List<Vehicle> findAll();
    List<Vehicle> findAllByDate(LocalDate since, LocalDate to);
    List<Vehicle> findAllByPrice(Double since, Double to);
    Optional<Vehicle> findById(UUID id);
}

package com.example.concesionaria.repository;
import com.example.concesionaria.entities.Vehicle;
import java.util.List;
import java.util.UUID;

public interface IVehicleRepository {
    UUID save(Vehicle vehicle);
    List<Vehicle> findAll();
    Vehicle findById(UUID id);
}

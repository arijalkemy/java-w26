package com.example.concesionaria_autos.repository.VehicleRepository;
import com.example.concesionaria_autos.entities.Vehicle;
import java.util.List;
import java.util.UUID;

public interface IVehicleRepository {
    UUID save(Vehicle vehicle);
    List<Vehicle> findAll();
    Vehicle findById(UUID id);
}

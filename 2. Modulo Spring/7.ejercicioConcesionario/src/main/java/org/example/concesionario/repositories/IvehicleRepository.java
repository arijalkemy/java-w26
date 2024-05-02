package org.example.concesionario.repositories;

import org.example.concesionario.model.Vehicle;

import java.util.List;

public interface IvehicleRepository {

    void createVehicle(Vehicle vehicle);
    List<Vehicle> allVehicles();
    Vehicle findVehicleById(int Id);
}

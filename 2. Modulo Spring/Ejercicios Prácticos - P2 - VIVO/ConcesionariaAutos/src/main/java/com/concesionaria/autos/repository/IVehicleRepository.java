package com.concesionaria.autos.repository;

import com.concesionaria.autos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    void loadVehicles();
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}

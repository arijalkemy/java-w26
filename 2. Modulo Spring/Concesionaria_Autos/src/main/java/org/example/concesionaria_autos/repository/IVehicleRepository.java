package org.example.concesionaria_autos.repository;

import org.example.concesionaria_autos.entity.Vehicle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IVehicleRepository {
    public String addNewVehicle(Vehicle vehicle);
    public List<Vehicle> getAll();
    public Vehicle getVehicleById(int id);
    public List<Vehicle> findVehicleByPrice(int since, int to);
    public List<Vehicle> getVehiclesByDate(String since, String to);
}

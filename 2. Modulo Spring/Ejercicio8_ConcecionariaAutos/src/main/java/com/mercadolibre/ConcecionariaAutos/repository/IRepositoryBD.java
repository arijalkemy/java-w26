package com.mercadolibre.ConcecionariaAutos.repository;

import com.mercadolibre.ConcecionariaAutos.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IRepositoryBD {
    public boolean saveVehicle(Vehicle vehicle);
    public List<Vehicle> getAllVehicles();
    public List<Vehicle> getVehiclesByManufacturingDate(LocalDate since, LocalDate to);
    public List<Vehicle> getVehiclesByPrice(double since, double to);
    public Vehicle getVehicleById(int id);
}

package com.meli.concesionariaDeAutos.repository;

import com.meli.concesionariaDeAutos.dto.VehicleDto;
import com.meli.concesionariaDeAutos.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    void saveVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();

    List<Vehicle> getVehiclesByDate(String since, String to);

    List<Vehicle> getVehiclesByPrice(double since, double to);

    Vehicle getVehicleById(String id);
}

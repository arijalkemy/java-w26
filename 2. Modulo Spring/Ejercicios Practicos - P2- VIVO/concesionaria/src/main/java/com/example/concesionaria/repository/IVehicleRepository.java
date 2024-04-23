package com.example.concesionaria.repository;

import com.example.concesionaria.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    List<Vehicle> getAllVehicles();
    List<Vehicle> getAllVehiclesByDate(Integer sinceDate, Integer toDate);
    List<Vehicle> getAllVehiclesByPrice(Double sincePrice, Double toPrice);
    Vehicle getVehicleById(Integer id);
    Integer createVehicle(Vehicle vehicle);






}

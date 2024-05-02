package org.bootcamp.concesionary.repository;

import org.bootcamp.concesionary.model.Vehicle;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface VehicleRepository {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(String id);
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getVehiclesBetweenDates(Date since, Date to);
    List<Vehicle> getVehiclesBetweenPrices(Integer since, Integer to);
}

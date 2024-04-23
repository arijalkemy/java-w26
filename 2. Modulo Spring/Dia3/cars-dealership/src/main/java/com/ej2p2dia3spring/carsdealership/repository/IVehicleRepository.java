package com.ej2p2dia3spring.carsdealership.repository;

import com.ej2p2dia3spring.carsdealership.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository {
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    List<Vehicle> getVehiclesByManufacturingDate(String fromDate, String toDate);
    List<Vehicle> getVehiclesByPrice(int minPrice, int maxPrice);
    Vehicle getVehicleById(int id);
}

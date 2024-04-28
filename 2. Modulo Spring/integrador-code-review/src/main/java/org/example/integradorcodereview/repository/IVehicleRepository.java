package org.example.integradorcodereview.repository;

import org.example.integradorcodereview.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository{

    List<Vehicle> getAllVehicle();
    Vehicle getVehicleById(Long id);
    Vehicle addVehicle(Vehicle vehicle);
    Boolean vehicleExists(Long id);
    List<Vehicle> findVehiclesColorYear(String color, Integer year);
    List<Vehicle> findVehiclesBrandYearRange(String brand, Integer startYear, Integer endYear);
    Double getAverageSpeed(String brand);
    Double getAveragePassengers(String brand);
    Vehicle updateVehicleSpeed(Long id, Vehicle vehicle);
    List<Vehicle> findVehiclesFuelType(String fuelType);
    List<Vehicle> findVehiclesTransmissionType(String transmissionType);
    void deleteVehicle(Long id);
    List<Vehicle> findVehiclesMeasuresRange(Double minLength, Double maxLength, Double minWidth, Double maxWidth);
    List<Vehicle> findVehiclesWeightRange(Double minWeight, Double maxWeight);
}

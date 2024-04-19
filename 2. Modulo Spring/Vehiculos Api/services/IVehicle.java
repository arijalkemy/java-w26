package org.example.vehicles.services;

import org.example.vehicles.dto.VehicleEntryDto;
import org.example.vehicles.dto.VehicleExitDto;
import org.example.vehicles.entities.Vehicle;

import java.util.List;

public interface IVehicle {
    String createVehicle(VehicleEntryDto vehicle);

    List<VehicleExitDto> getVehicles();

    Vehicle getVehicleById(Integer id);

    List<Vehicle> getVehiclesBetweenDates(String since, String to);

    List<Vehicle> getVehiclesBetweenPrices(Integer since, Integer to);
}

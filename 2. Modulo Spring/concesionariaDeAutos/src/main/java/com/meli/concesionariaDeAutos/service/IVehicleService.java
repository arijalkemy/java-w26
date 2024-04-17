package com.meli.concesionariaDeAutos.service;

import com.meli.concesionariaDeAutos.dto.VehicleDto;
import com.meli.concesionariaDeAutos.model.Vehicle;

import java.util.List;

public interface IVehicleService {

    void saveVehicle(Vehicle vehicle);
    List<VehicleDto> getVehicles();

    List<VehicleDto> getVehiclesByDate(String since, String to);

    List<VehicleDto> getVehiclesByPrice(double since, double to);

    VehicleDto getVehicleById(String id);
}

package org.example.concesionaria_autos.service;

import org.example.concesionaria_autos.entity.Vehicle;
import org.example.concesionaria_autos.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    public String addNewVehicle(Vehicle vehicle);
    public List<VehicleDto> getAll();
    public VehicleDto getVehicleById(int id);
    public List<VehicleDto> getVehicleByPrice(int since, int to);
    public List<VehicleDto> getVehiclesByDate(String since,String to);
}

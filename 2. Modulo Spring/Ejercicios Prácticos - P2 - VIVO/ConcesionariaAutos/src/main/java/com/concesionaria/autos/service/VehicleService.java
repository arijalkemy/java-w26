package com.concesionaria.autos.service;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.entity.Vehicle;
import com.concesionaria.autos.repository.IVehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService implements IVehicleService{

    IVehicleRepository vehicleRepository;
    ObjectMapper mapper;

    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        mapper = new ObjectMapper();
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapper.convertValue(vehicleDTO, Vehicle.class);
        vehicleRepository.addVehicle(vehicle);
        return vehicleDTO;
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.getAllVehicles().stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class)).toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesByDate(String sinceDate, String toDate) {
        LocalDate since = LocalDate.parse(sinceDate);
        LocalDate to = LocalDate.parse(toDate);
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> LocalDate.parse(vehicle.getManufacturingDate()).compareTo(since) >= 0 && LocalDate.parse(vehicle.getManufacturingDate()).compareTo(to) <= 0)
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class)).toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(Double min, Double max) {
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max)
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class)).toList();
    }

    @Override
    public VehicleDTO getVehicleById(int id) {
        return mapper.convertValue(vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> vehicle.getId() == id)
                .findFirst().orElse(null), VehicleDTO.class);
    }
}

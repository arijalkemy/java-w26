package org.ejercicio.conocesionaria.service.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.ejercicio.conocesionaria.dto.VehicleDTO;
import org.ejercicio.conocesionaria.entity.Vehicle;
import org.ejercicio.conocesionaria.repository.VehicleRepository;
import org.ejercicio.conocesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleDTO findById(UUID id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.convertValue(vehicle, VehicleDTO.class);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicle;
    }


    @Override
    public List<VehicleDTO> getAllVehicles() {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return objectMapper.convertValue(vehicles, new TypeReference<List<VehicleDTO>>() {});
    }

    @Override
    public List<VehicleDTO> getAllVehiclesByDate(LocalDate since, LocalDate to) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Vehicle> vehicles = vehicleRepository.getAllVehiclesByDate(since, to);
        return objectMapper.convertValue(vehicles, new TypeReference<List<VehicleDTO>>() {});
    }

    @Override
    public List<VehicleDTO> getAllVehiclesByPrices(double since, double to) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Vehicle> vehicles = vehicleRepository.getAllVehiclesByPrices(since, to);
        return objectMapper.convertValue(vehicles, new TypeReference<List<VehicleDTO>>() {});
    }

    @Override
    public List<VehicleDTO> getAllVehiclesByOwners() {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Vehicle> vehicles = vehicleRepository.getAllVehiclesByOwners();
        return objectMapper.convertValue(vehicles, new TypeReference<List<VehicleDTO>>() {});
    }
}

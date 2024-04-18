package com.example.concesionaria.service.vehicleService.impl;

import com.example.concesionaria.dto.VehicleDto;
import com.example.concesionaria.entities.Vehicle;
import com.example.concesionaria.repository.VehicleRepository.IVehicleRepository;
import com.example.concesionaria.service.vehicleService.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public void createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = mapToEntity(vehicleDto);
        vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(d-> {
            VehicleDto vehicleDto = mapToDto(d);
            vehicleDto.setServices(null);
            return vehicleDto;
        }).toList();
    }

    @Override
    public List<VehicleDto> getAllVehiclesByDate(String since, String to) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate toDate = LocalDate.parse(to);

        List<Vehicle> vehicles = vehicleRepository.findAllByDate(sinceDate, toDate);

        return vehicles.stream().map(this::mapToDto).toList();
    }

    @Override
    public List<VehicleDto> getAllVehiclesByPrice(Double since, Double to) {
        List<Vehicle> vehicles = vehicleRepository.findAllByPrice(since, to);
        return vehicles.stream().map(this::mapToDto).toList();
    }

    @Override
    public Optional<VehicleDto> getVehicleById(UUID id) {
        return vehicleRepository.findById(id).map(this::mapToDto);
    }

    private VehicleDto mapToDto(Vehicle vehicle){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(vehicle, VehicleDto.class);
    }

    private Vehicle mapToEntity(VehicleDto vehicleDto){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(vehicleDto, Vehicle.class);
    }
}

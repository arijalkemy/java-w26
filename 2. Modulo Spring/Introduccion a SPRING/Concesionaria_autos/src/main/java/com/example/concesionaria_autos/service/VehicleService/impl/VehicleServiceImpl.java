package com.example.concesionaria_autos.service.VehicleService.impl;

import com.example.concesionaria_autos.dto.VehicleRequestDto;
import com.example.concesionaria_autos.dto.VehicleResponseDto;
import com.example.concesionaria_autos.entities.Vehicle;
import com.example.concesionaria_autos.exceptions.NotFoundException;
import com.example.concesionaria_autos.repository.VehicleRepository.IVehicleRepository;
import com.example.concesionaria_autos.service.VehicleService.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public UUID createVehicle(VehicleRequestDto vehicleDto) {
        Vehicle vehicle = mapToEntity(vehicleDto);
        vehicle.setId(UUID.randomUUID());
        UUID idCreated = vehicleRepository.save(vehicle);
        return idCreated;
    }

    @Override
    public VehicleResponseDto getVehicle(UUID id) {
        Vehicle vehicle = vehicleRepository.findById(id);

        if (vehicle == null){
            throw new NotFoundException("No se encontró el vehiculo");
        }

        return mapToDto(vehicle);

    }

    @Override
    public List<VehicleResponseDto> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(this::mapToDto).toList();
    }

    @Override
    public List<VehicleResponseDto> getVehiclesByDate(LocalDate since, LocalDate to) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().filter(vehicle -> {
            LocalDate manufacturingDate = LocalDate.parse(vehicle.getManufacturingDate());
            return !manufacturingDate.isBefore(since) && !manufacturingDate.isAfter(to);
        }).map(this::mapToDto).toList();
    }

    @Override
    public List<VehicleResponseDto> getVehiclesByPrice(Double since, Double to) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles
                .stream()
                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                .map(this::mapToDto)
                .toList();
    }

    private Vehicle mapToEntity(VehicleRequestDto vehicleDto){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(vehicleDto, Vehicle.class);
    }

    private VehicleResponseDto mapToDto(Vehicle vehicle){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(vehicle, VehicleResponseDto.class);
    }
}

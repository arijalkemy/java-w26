package com.example.demo.service;

import com.example.demo.dto.VehicleResponseDto;
import com.example.demo.repository.IVehicleRepository;
import com.example.demo.dto.VehicleDto;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Scope("singleton")
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;
    private Long cont = 0L;

    @Autowired
    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public boolean addVehicle(VehicleDto vehicleDto) {
        ++cont;
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        vehicle.setId(cont);
        vehicleRepository.getVehicles().add(vehicle);
        return true;
    }

    public List<VehicleResponseDto> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        List<VehicleResponseDto> vehicleResponseDtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            VehicleResponseDto vehicleResponseDto = getVehicleResponseDto(vehicle);
            vehicleResponseDtos.add(vehicleResponseDto);
        }
        //vehicles.forEach(vehicle -> vehicleResponseDtos.add(mapper.convertValue(vehicle, VehicleResponseDto.class)));
        return vehicleResponseDtos;
    }

    private static VehicleResponseDto getVehicleResponseDto(Vehicle vehicle) {
        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto();
        vehicleResponseDto.setId(vehicle.getId());
        vehicleResponseDto.setBrand(vehicle.getBrand());
        vehicleResponseDto.setModel(vehicle.getModel());
        vehicleResponseDto.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleResponseDto.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleResponseDto.setDoors(vehicle.getDoors());
        vehicleResponseDto.setPrice(vehicle.getPrice());
        vehicleResponseDto.setCurrency(vehicle.getCurrency());
        vehicleResponseDto.setCountOfOwners(vehicle.getCountOfOwners());
        return vehicleResponseDto;
    }

    public List<VehicleDto> getVehiclesBetweenDates(Date since, Date to) {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        // Filtro por vechivulos que se encuentren en el rango de fehcas indicado
        List<Vehicle> vehiclesBetweenDates = vehicles
                .stream()
                .filter(v -> v.getManufacturingDate().after(since) && v.getManufacturingDate().before(to))
                .toList();

        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        vehiclesBetweenDates
                .stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .forEach(vehicleDtos::add);

        return vehicleDtos;
    }

    public List<VehicleDto> getVehiclesBetweenPrices(Double since, Double to) {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        List<Vehicle> vehiclesBetweenPrices = vehicles
                .stream()
                .filter(v -> v.getPrice() > since && v.getPrice() < to)
                .toList();

        ObjectMapper mapper = new ObjectMapper();
        return vehiclesBetweenPrices.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    public VehicleDto getVehicle(Long id) {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        Vehicle vehicle = vehicles.stream().filter(v -> v.getId().equals(id)).findFirst().get();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicle, VehicleDto.class);
    }
}

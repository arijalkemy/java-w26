package com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.service.impl;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.ResponseDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.ServiceDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.VehicleDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.VehicleWithServicesDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.entity.Vehicle;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.repository.IVehicleRepository;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.service.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private final IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return vehicles.stream()
            .map(v -> objectMapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public VehicleWithServicesDto searchVehicleById(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isPresent()) {
            List<ServiceDto> servicesDto = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();

            for(com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.entity.Service service : vehicle.get().getServices()) {
                servicesDto.add(
                  objectMapper.convertValue(service, ServiceDto.class)
                );
            }

            return new VehicleWithServicesDto(
                vehicle.get().getId(),
                vehicle.get().getBrand(),
                vehicle.get().getModel(),
                vehicle.get().getManufacturingDate(),
                vehicle.get().getNumberOfKilometers(),
                vehicle.get().getDoors(),
                vehicle.get().getPrice(),
                vehicle.get().getCurrency(),
                servicesDto,
                vehicle.get().getCountOfOwners()
            );
        } else {
            throw new RuntimeException("Vehiculo no encontrado!");
        }
    }

    @Override
    public List<VehicleDto> searchVehiclesByManufacturingDate(int since, int to) {
        List<Vehicle> vehicles = vehicleRepository.findAllByManufacturingDate(since, to);
        List<VehicleDto> vehiclesDto = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for(Vehicle vehicle : vehicles) {
            vehiclesDto.add(
                objectMapper.convertValue(vehicle, VehicleDto.class)
            );
        }
        return vehiclesDto;
    }

    @Override
    public List<VehicleDto> searchVehiclesByPrice(int min, int max) {
        List<Vehicle> vehicles = vehicleRepository.findAllByPrice(min, max);
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream()
            .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    @Override
    public ResponseDto createVehicle(VehicleWithServicesDto vehicleWithServicesDto) {
        ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        vehicleRepository.createVehicle(
            objectMapper.convertValue(vehicleWithServicesDto, Vehicle.class)
        );
        return new ResponseDto("Vehiculo guardado con éxito!");
    }
}

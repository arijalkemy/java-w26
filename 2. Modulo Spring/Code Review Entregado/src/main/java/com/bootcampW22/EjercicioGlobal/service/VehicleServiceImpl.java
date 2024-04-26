package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> getVehicleByBrand(String brand) {
        // Traigo la lista de vehiculos que me provee el repositorio y filtro por lista
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        vehicleList = vehicleList.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .collect(Collectors.toList());
        // Valido que hayan objetos de tipo vehiculo para esta lista
        if (vehicleList.isEmpty()) {
            return new ResponseEntity<>("No vehicles found for the brand: " + brand, HttpStatus.NOT_FOUND);
        }

        // Calculo el promedio y parseo el getMax_speed que en la entidd es de tipo String
        double averageMaxSpeed = vehicleList.stream()
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .average()
                .orElse(0.0);

        // mapeo la lista del repositorio a una de tipo Dto
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtoList = vehicleList.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
        // Creo un mapa para mostrar el promedio de velocidad calculado y los vehiculos filtrados por marca
        Map<String, Object> response = new HashMap<>();
        response.put("averageMaxSpeed", averageMaxSpeed);
        response.put("vehicles", vehicleDtoList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

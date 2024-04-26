package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleRequestDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleResponseDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }


    //Punto 1
    @Override
    public Optional<Vehicle> createVehicle(VehicleRequestDto vehicleRequestDto) {
        Vehicle vehicle = mapToEntity(vehicleRequestDto);
        if (vehicleRequestDto.getId() == null){
            throw new BadRequestException("Datos del vehículo mal formados o incompletos.\n");
        }
        vehicleRepository.saveVehicle(vehicle);
        return Optional.ofNullable(vehicle);
    }

    @Override
    public VehicleResponseDto getVehicleBy(String color, Integer year) {
        List<Vehicle> filteredVehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year)
                .collect(Collectors.toList());
        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningún vehículo con el color " + color + " y el año " + year);
        }
        Vehicle vehicle = filteredVehicles.get(0);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicle, VehicleResponseDto.class);
    }

    @Override
    public ResponseEntity<?> deleteVehicle(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getByBrand(String brand) {
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



    private Vehicle mapToEntity(VehicleRequestDto vehicleDto){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(vehicleDto, Vehicle.class);
    }

    private VehicleResponseDto mapToDto(Vehicle vehicle){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(vehicle, VehicleResponseDto.class);
    }

}

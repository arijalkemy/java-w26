package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    // Ejercicio Auxiliar findAll()
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

    // Ejercicio 1
    @Override
    public void createVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        vehicleRepository.addVehicle(vehicle);
    }

    // Ejercicio 2
    @Override
    public ResponseEntity<?> getVehicleByColorAndAge(String color, int year) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<Vehicle> filteredVehicles = vehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year)
                .collect(Collectors.toList());

        List<Vehicle> sortedVehicles = filteredVehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getColor).thenComparing(Vehicle::getYear))
                .collect(Collectors.toList());

        if (sortedVehicles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(sortedVehicles, HttpStatus.OK);
        }
    }

    // Ejercicio 3
    @Override
    public ResponseEntity<?> getVehicleByBrandAndAgeRange(String brand, int sinceYear, int toYear) {
        List<Vehicle> allvehicles = vehicleRepository.findAll();
        List<Vehicle> filtredVehicles = allvehicles.stream().
                filter(vehicle -> vehicle.getBrand().equals(brand) && vehicle.getYear() >= sinceYear && vehicle.getYear() <= toYear)
                .collect(Collectors.toList());
        if (filtredVehicles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(filtredVehicles, HttpStatus.OK);
        }
    }

    // Ejercicio 4
    @Override
    public ResponseEntity<?> getVehicleAverageByBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<Vehicle> filtredByBrand = vehicles.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).collect(Collectors.toList());
        if (filtredByBrand.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        OptionalDouble average = filtredByBrand.stream()
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .average();
        return new ResponseEntity<>(average, HttpStatus.OK);
    }

    // Ejercicio 5
    @Override
    public ResponseEntity<?> createVehicles(List<VehicleDto> vehicles) {
        if (vehicles.isEmpty() || vehicles.stream().anyMatch(vehicle -> vehicle.getId() == null || vehicle.getBrand() == null || vehicle.getMax_speed() == null)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Vehicle> existingVehicles = vehicleRepository.findAll();
        if (vehicles.stream().anyMatch(newVehicle -> existingVehicles.stream().anyMatch(existingVehicle -> existingVehicle.getId().equals(newVehicle.getId())))) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        ObjectMapper mapper = new ObjectMapper();
        vehicles.forEach(vehicleDto -> {
            Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
            vehicleRepository.addVehicle(vehicle);
        });
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Ejercicio 6
    @Override
    public ResponseEntity<?> updateSpeedById(Long id) {
        List <Vehicle> vehicles = vehicleRepository.findAll();
        Optional<Vehicle> vehicleById = vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findAny();
        if (vehicleById.isPresent()){
            Vehicle vehicleToUpdate = vehicleById.get();
            String newMaxSpeed = "240";
            vehicleToUpdate.setMax_speed(newMaxSpeed);
            return new ResponseEntity<>(vehicleToUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Ejercicio 7
    @Override
    public ResponseEntity<?> getVehiclesByFuelType(String type) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<Vehicle> filteredVehicles = vehicles.stream()
                .filter(vehicle -> type.equals(vehicle.getFuel_type()))
                .collect(Collectors.toList());

        if (filteredVehicles.isEmpty()) {
            throw new BadRequestException("No se ha encontrado ningun vehiculo con ese tipo de gasolina");
        } else {
            return new ResponseEntity<>(filteredVehicles, HttpStatus.OK);
        }
    }

    // Ejercicio 8
    @Override
    public ResponseEntity<?> deleteVehicle(Long id) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        boolean isRemoved = vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
        if (isRemoved) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Ejercicio 9
    @Override
    public ResponseEntity<?> getVehiclesByTransmission(String transmission) {
        List <Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> vehiclesByTransmission = vehicleList.stream().filter(vehicle -> vehicle.getTransmission().equals(transmission)).collect(Collectors.toList());
        if (vehiclesByTransmission.isEmpty()){
            throw new BadRequestException("No se ha encontrado ningun vehiculo con ese tipo de transmision");
        }
        return new ResponseEntity<>(vehiclesByTransmission, HttpStatus.OK);
    }

    // Ejercicio 10
    @Override
    public ResponseEntity<?> updateByTrasmission(Long id) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        Optional<Vehicle> vehicleById = vehicleList.stream().filter(vehicle -> vehicle.getId().equals(id)).findAny();
        vehicleById.ifPresent(vehicle -> vehicle.setTransmission("Automatic"));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // Funcion auxiliar
    @Override
    public ResponseEntity<?> getVehicleById(Long id) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        Vehicle vehicle = vehicles.stream().filter(v -> v.getId().equals(id)).findAny().orElse(null);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }


    // Ejercicio 11
    @Override
    public ResponseEntity<?> getAverageOfBrandCapacity(String brand) {
        List <Vehicle> vehicles = vehicleRepository.findAll();

       List<Vehicle> vehiclesByBrand = vehicles
               .stream()
               .filter(vehicle -> vehicle.getBrand().equals(brand))
               .collect(Collectors.toList());

        OptionalDouble averageOfCapacity = vehiclesByBrand
                .stream()
                .mapToInt(value -> value.getPassengers())
                .average();

        return new ResponseEntity<>(averageOfCapacity, HttpStatus.OK);
    }

    // Ejercicio 13
    @Override
    public ResponseEntity<?> getVehicleByWeight(Double weight_min, Double weight_max) {
        return null;
    }

    // Ejercicio 14
}

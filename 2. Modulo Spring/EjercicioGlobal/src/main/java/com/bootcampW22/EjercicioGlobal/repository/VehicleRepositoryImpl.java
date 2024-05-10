package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {


    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;

        file = ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {
        });

        listOfVehicles = vehicles;
    }

    // Ejercicio
    @Override
    public void saveVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = convertToVehicle(vehicleDto);
        listOfVehicles.add(vehicle);
    }

    // Ejercicio 1
    private Vehicle convertToVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicleDto, Vehicle.class);
    }

    // Ejercicio 2
    @Override
    public List<Vehicle> searchByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = this.listOfVehicles.stream().filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year).collect(Collectors.toList());
        return vehicles;
    }

    // Ejercicio 3
    @Override
    public List<Vehicle> searchByBrandAndYearRange(String brand, int start_year, int end_year) {
        List<Vehicle> vehicles = this.listOfVehicles.stream().filter(vehicle -> vehicle.getBrand().equals(brand) && vehicle.getYear() >= start_year && vehicle.getYear() <= end_year).collect(Collectors.toList());
        return vehicles;
    }

    // Ejercicio 4
    @Override
    public int getAvgSpeedByBrand(String brand) {
        return (int) this.listOfVehicles.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed())).average().orElse(0.0);
    }

    // Ejercicio 5
    @Override
    public List<Vehicle> saveVehicleBatch(List<VehicleDto> vehicleDto) {
        for (VehicleDto dto : vehicleDto) {
            Vehicle vehicle = convertToVehicle(dto);
            Long findId = dto.getId();
            Optional<Vehicle> vehicle1 = this.listOfVehicles.stream().filter(vehicle2 -> vehicle2.getId().equals(findId)).findFirst();
            if (vehicle1.isPresent()) {
                throw new IllegalArgumentException("Vehiculo con el id " + findId + " ya registrado");
            } else {
                this.listOfVehicles.add(vehicle);
            }
        }
        return listOfVehicles;
    }

    // Ejercicio 6
    @Override
    public Optional<Vehicle> findById(Long id) {
        return this.listOfVehicles.stream().filter(vehicle1 -> vehicle1.getId().equals(id)).findFirst();
    }

    // Ejercicio 7
    @Override
    public List<Vehicle> searchByFuel(String type) {
        return this.listOfVehicles.stream().filter(vehicle -> vehicle.getFuel_type().equals(type)).collect(Collectors.toList());
    }

    // Ejercicio 8
    @Override
    public void deleteById(Long id) {
        Optional<Vehicle> vehicle = this.listOfVehicles.stream().filter(vehicle1 -> vehicle1.getId().equals(id)).findFirst();
        if (vehicle.isEmpty()) {
            throw new NotFoundException("No se encuentra el registro");
        }
        Vehicle vehicleToRemove = vehicle.get();
        this.listOfVehicles.remove(vehicleToRemove);
    }

    // Ejercicio 9
    @Override
    public List<Vehicle> searchByTransmission(String type) {
        return this.listOfVehicles.stream().filter(vehicle -> vehicle.getTransmission().equals(type)).collect(Collectors.toList());
    }

    // Ejercicio 11
    @Override
    public Double getAvgByBrand(String brand) {
        return this.listOfVehicles.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).mapToDouble(Vehicle::getPassengers).average().orElse(0.0);
    }

    // Ejercicio 12
    @Override
    public List<Vehicle> searchByDimensions(String length, String width) {
        String[] arrLength = length.split("-");
        String[] arrWidth = width.split("-");
        double minLength, maxLength, minWidth, maxWidth;

        if (arrLength.length == 2) {
            minLength = Double.parseDouble(arrLength[0]);
            maxLength = Double.parseDouble(arrLength[1]);
        } else {
            throw new IllegalArgumentException("Medidas invalidas");
        }
        if (arrWidth.length == 2) {
            minWidth = Double.parseDouble(arrWidth[0]);
            maxWidth = Double.parseDouble(arrWidth[1]);
        } else {
            throw new IllegalArgumentException("Medidas invalidas");
        }
        return this.listOfVehicles.stream().filter(vehicle -> vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength && vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth).collect(Collectors.toList());
    }

    // Ejercicio 13
    @Override
    public List<Vehicle> searchByWeightRange(double min, double max) {
        return this.listOfVehicles.stream().filter(vehicle -> vehicle.getWeight() >= min && vehicle.getWeight() <= max).collect(Collectors.toList());
    }
}

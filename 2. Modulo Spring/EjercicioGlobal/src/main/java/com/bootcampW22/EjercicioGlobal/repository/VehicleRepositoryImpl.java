package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.AvgSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.MaxSpeedDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    public Vehicle addVehicle(Vehicle v) {
        listOfVehicles.add(v);
        return v;
    }

    @Override
    public Optional<Vehicle> findVehicleById(Long id) {
        return listOfVehicles.stream().filter(v -> v.getId().equals(id)).findAny();
    }

    @Override
    public List<Vehicle> findVehicleByColorAndYear(String color, int year) {
        return listOfVehicles.stream().filter(v -> v.getColor().toLowerCase()
                .equals(color.toLowerCase()) && v.getYear() == year).toList();
    }

    @Override
    public List<Vehicle> findVehiclesByBrandAndRangeOfYears(String brand, int start_year, int end_year) {
        return listOfVehicles.stream().filter(v -> v.getBrand().toLowerCase()
                .equals(brand.toLowerCase()) && v.getYear() >= start_year && v.getYear() <= end_year).toList();
    }

    @Override
    public List<Vehicle> findVehiclesByBrand(String brand) {
        List<Vehicle> vehiclesByMarca = listOfVehicles.stream().filter(v -> v.getBrand().toLowerCase()
                .equals(brand)).toList();
        return vehiclesByMarca;
    }

    @Override
    public List<Vehicle> findVehicleByFuelType(String fuel_type) {
        List<Vehicle> vehiclesByFuelType = listOfVehicles.stream().filter(v -> v.getFuel_type().toLowerCase()
                .equals(fuel_type.toLowerCase())).toList();
        return vehiclesByFuelType;
    }

    @Override
    public List<Vehicle> addVehicles(List<Vehicle> listVehicles) {
        listVehicles.stream().forEach(v ->
        {
            listOfVehicles.add(v);
        });
        return listOfVehicles;
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        listOfVehicles.stream().forEach(v -> {
            if (v.getId().equals(vehicle.getId())) {
                v.setBrand(vehicle.getBrand());
                v.setModel(vehicle.getModel());
                v.setRegistration(vehicle.getRegistration());
                v.setColor(vehicle.getColor());
                v.setColor(vehicle.getColor());
                v.setYear(vehicle.getYear());
                v.setMax_speed(vehicle.getMax_speed());
                v.setPassengers(vehicle.getPassengers());
                v.setFuel_type(vehicle.getFuel_type());
                v.setTransmission(vehicle.getTransmission());
                v.setHeight(vehicle.getHeight());
                v.setWeight(vehicle.getWeight());
                v.setWidth(vehicle.getWidth());
            }
        });
        return vehicle;
    }

    @Override
    public Vehicle deleteVehicle(Vehicle vehicleToDelete) {
        listOfVehicles.remove(vehicleToDelete);
        return vehicleToDelete;
    }

    @Override
    public List<Vehicle> findVehiclesByTransmission(String transmission) {
        return listOfVehicles.stream().filter(v -> v.getTransmission().toLowerCase()
                .equals(transmission.toLowerCase())).toList();
    }

    @Override
    public List<Vehicle> findVehiclesByDimenssions(double min_length, double max_length, double min_width, double max_width) {
        return listOfVehicles.stream().filter(v -> v.getHeight() >= min_length
        && v.getHeight() <= max_length && v.getWidth() >= min_width && v.getWidth() <= max_width).toList();
    }

    @Override
    public List<Vehicle> findVehiclesByWeightRange(double min, double max) {
        return listOfVehicles.stream().filter(v -> v.getWeight() >= min && v.getWeight() <= max).toList();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;

        file = ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {
        });
        System.out.println(vehicles);
        listOfVehicles = vehicles;
    }
}

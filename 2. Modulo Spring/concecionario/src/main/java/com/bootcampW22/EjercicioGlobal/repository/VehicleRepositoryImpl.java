package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        listOfVehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public boolean existsById(Long id) {
        for (Vehicle vehicle : listOfVehicles) {

            if (vehicle.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle findById(Long id) {

        for (Vehicle v : listOfVehicles){
            if(Objects.equals(v.getId(), id)){
                return v;
            }
        }

        return null;
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : listOfVehicles){
            if( v.getColor().equalsIgnoreCase(color) && v.getYear() == year){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {


        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    @Override
    public List<Vehicle> findByFuelType(String fuelType) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByTransmission(String type) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        listOfVehicles.removeIf(v -> v.getId().equals(id));
    }

    @Override
    public List<Vehicle> findByDimensions(double min_height, double max_height, double min_width, double max_width) {

        List<Vehicle> vehicles = new ArrayList<>();

        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getHeight() >= min_height && vehicle.getHeight() <= max_height)
                .filter(vehicle -> vehicle.getWidth() >= min_width && vehicle.getWidth() <= max_width)
                .collect(Collectors.toList());
    }
}

package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.PushBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    public List<Vehicle> searchById(Long id){
        for(Vehicle vehicle : listOfVehicles){
            if(vehicle.getId() == id){
                return this.listOfVehicles;
            }else {
                return null;
            }
        }
        return null;
    }

    @Override
    public  List<Vehicle> searchByRange(double min, double max){
        List<Vehicle> range = this.listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWeight() >= min && vehicle.getWeight() <= max)
                .collect(Collectors.toList());
        return range;
    }

    @Override
    public Optional<Vehicle> changeData(Long id, String fuel_type) {

        Optional<Vehicle> selected = this.listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId() == id).findFirst();

        return selected;
    }

    @Override
    public List<Vehicle> searchByFuel(String fuel_type) {
        List<Vehicle> vehicles = this.listOfVehicles.stream().filter(vehicle -> vehicle.getFuel_type().equals(fuel_type)).collect(Collectors.toList());
        return vehicles;
    }

    @Override
    public Double searchBrandAvg(String brand) {
        double avg = this.listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .average()
                .orElse(0);
         return avg;
    }
}

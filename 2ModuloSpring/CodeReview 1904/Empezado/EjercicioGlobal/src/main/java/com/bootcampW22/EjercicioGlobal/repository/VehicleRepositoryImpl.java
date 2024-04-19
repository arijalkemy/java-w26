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

    @Override
    public Vehicle getLast() {
        return listOfVehicles.get(listOfVehicles.size() - 1);
    }

    @Override
    public void addOne(Vehicle vehicle){
        listOfVehicles.add(vehicle);

    }

    @Override
    public List<Vehicle> findByFuelType(String fuelType) {
        return listOfVehicles.stream().filter(v->v.getFuel_type().equals(fuelType)).toList();
    }

    @Override
    public List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth) {

        return listOfVehicles.stream()
                .filter( a -> (a.getHeight()<maxHeight && a.getHeight()> minHeight)
                        &&(a.getWidth()>minWidth && a.getWidth()<maxWidth)).toList();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}

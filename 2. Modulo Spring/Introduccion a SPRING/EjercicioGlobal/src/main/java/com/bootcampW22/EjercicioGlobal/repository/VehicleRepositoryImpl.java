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
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public void save(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public void update(Long id, Vehicle vehicle) {
        listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst().ifPresent(v -> {
            int index = listOfVehicles.indexOf(v);
            listOfVehicles.set(index, vehicle);
        });
    }

    @Override
    public void delete(Long id) {
        listOfVehicles.removeIf(v -> v.getId().equals(id));
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}

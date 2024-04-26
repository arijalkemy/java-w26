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
    public boolean save(Vehicle vehicle) {
        if (exist(vehicle.getId())) {
            return false;
        }
        listOfVehicles.add(vehicle);
        return true;
    }

    @Override
    public boolean exist(Long id) {
        if (listOfVehicles.stream().anyMatch(x -> x.getId().equals(id))) {
            return true;
        }
        return false;
    }

    @Override
    public Vehicle getById(Long id) {
        return listOfVehicles.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        //int index = listOfVehicles.indexOf(vehicle);
        //listOfVehicles.set(index, vehicle);
    }

    @Override
    public boolean deleteVehicle(Long id) {
        if (exist(id)) {
            listOfVehicles.remove(getById(id));
            return true;
        }
        return false;
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
}

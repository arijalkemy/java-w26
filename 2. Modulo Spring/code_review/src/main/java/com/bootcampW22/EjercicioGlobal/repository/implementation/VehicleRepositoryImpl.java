package com.bootcampW22.EjercicioGlobal.repository.implementation;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.interfaces.IVehicleRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private List<Vehicle> listOfVehicles;

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

    @Override
    public void save(Vehicle toSave) {
        int toRemoveIndex = 0;
        for (int i = 0; i < listOfVehicles.size(); i++) {
            if(listOfVehicles.get(i).getId().equals(toSave.getId())) {
                toRemoveIndex = i;
            }
        }
        listOfVehicles.remove(toRemoveIndex);
        listOfVehicles.add(toSave);
    }
}

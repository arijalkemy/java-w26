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
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public boolean add(Vehicle vehicle) {
        if( exists(vehicle.getId()) ){
            return false;
        }
        this.listOfVehicles.add(vehicle);
        return true;
    }

    @Override
    public boolean updateMaxSpeed(Long id, Vehicle vehicle) {
        Optional<Vehicle> oldVehice = listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
        if( oldVehice.isEmpty() ){
            return false;
        }
        oldVehice.get().setMax_speed(vehicle.getMax_speed());
        return true;
    }


    //Verifica si un id de vehiculo ya existe en la lista
    private boolean exists( Long id ) {

        long size = this.listOfVehicles.stream().filter( v -> v.getId().equals( id ) ).count();
        return size > 0;
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

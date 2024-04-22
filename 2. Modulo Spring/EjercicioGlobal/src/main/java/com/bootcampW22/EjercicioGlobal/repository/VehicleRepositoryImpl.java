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
    public Optional<Vehicle>  findOne(Long id) {
        Optional<Vehicle> result = listOfVehicles.stream().filter(x->x.getId()==id).findFirst();
        return  result;
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findByColorYear(String color, int year) {
        List<Vehicle> vehicleList = listOfVehicles.stream()
                .filter(x->x.getColor().toLowerCase().
                        equals(color.toLowerCase())&& x.getYear() == year).toList();

        return vehicleList;
    }

    @Override
    public Vehicle updateFuel(Vehicle vehicle,Long id) {
        Vehicle vehicleRetorno = null;
        for (Vehicle item: listOfVehicles) {
            if(item.getId().equals(id))
            {
                item.setFuel_type(vehicle.getFuel_type());
                return item ;
            }
        }
        return vehicleRetorno;
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

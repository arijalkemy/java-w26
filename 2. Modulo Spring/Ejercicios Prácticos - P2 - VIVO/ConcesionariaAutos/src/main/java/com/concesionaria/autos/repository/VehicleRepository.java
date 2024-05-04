package com.concesionaria.autos.repository;

import com.concesionaria.autos.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository{
    List<Vehicle> vehicles;

    public VehicleRepository(){
        loadVehicles();
    }

    @Override
    public void loadVehicles() {
        String jsonFilePath = "src/main/resources/vehicles.json";

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            vehicles = mapper.readValue(json, new TypeReference<List<Vehicle>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}

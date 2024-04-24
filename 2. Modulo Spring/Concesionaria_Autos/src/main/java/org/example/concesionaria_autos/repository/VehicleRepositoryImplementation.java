package org.example.concesionaria_autos.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.concesionaria_autos.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImplementation implements IVehicleRepository {

    List<Vehicle> vehicles;

    VehicleRepositoryImplementation() throws IOException {
        vehicles = addInitialVehicles();
    }

    @Override
    public String addNewVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return "Vehicle added successfully";
    }

    @Override
    public Vehicle getVehicleById(int id) {
        Vehicle vehicle = null;
        for(Vehicle currentVehicle: vehicles)
        {
            if (currentVehicle.getId() == id)
            {
                vehicle = currentVehicle;
            }
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> findVehicleByPrice(int since, int to) {
        return vehicles
                .stream()
                .filter(v -> Integer.parseInt(v.getPrice()) >= since && Integer.parseInt(v.getPrice()) <= to)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> getVehiclesByDate(String since, String to) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate toDate = LocalDate.parse(to);


        return vehicles.stream()
                .filter( v -> LocalDate.parse(v.getManufacturingDate()).isAfter(sinceDate) && LocalDate.parse(v.getManufacturingDate()).isBefore(toDate) )
                .collect(Collectors.toList());
    }

    public List<Vehicle> addInitialVehicles() throws IOException {
        File file;
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> _vehicles;

        file = ResourceUtils.getFile("classpath:data.json");
        _vehicles = mapper.readValue(file, new TypeReference<List<Vehicle>>(){});

        return  _vehicles;

    }
}

package org.example.concesionaria.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.concesionaria.model.Vehicle;
import org.example.concesionaria.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private final List<Vehicle> vehicles;

    public VehicleRepositoryImpl() {

        try {
            File vechiclesFile = ResourceUtils.getFile("classpath:static/vehicles.json");

            ObjectMapper mapper = new ObjectMapper();
            // A lo siguiente es necesario hacerlo para que Jackson pueda deserializar a objetos de tipo LocalDate
            mapper.findAndRegisterModules();

            Vehicle[] vehiclesArray = mapper.readValue(vechiclesFile, Vehicle[].class);
            vehicles = Arrays.stream(vehiclesArray).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public Optional<Vehicle> findById(UUID id) {
        return vehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicles.add(vehicle);

        return vehicle;
    }

    @Override
    public List<Vehicle> findByManufacturingDate(LocalDate since, LocalDate to) {

        return vehicles.stream().filter(vehicle ->
            !vehicle.getManufacturingDate().isBefore(since)
            && !vehicle.getManufacturingDate().isAfter(to)
            )
            .toList();
    }

    @Override
    public List<Vehicle> findByPrice(Integer since, Integer to) {

        return vehicles.stream().filter(vehicle ->
                Integer.parseInt(vehicle.getPrice()) >= since
                && Integer.parseInt(vehicle.getPrice()) <= to
            )
            .toList();
    }
}

package org.example.vehicles.services.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.vehicles.dto.VehicleEntryDto;
import org.example.vehicles.dto.VehicleExitDto;
import org.example.vehicles.entities.Vehicle;
import org.example.vehicles.exeptions.VehicleNotFoundExeption;
import org.example.vehicles.repositories.VehicleRepository;
import org.example.vehicles.services.IVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Primary
public class VehicleImpl implements IVehicle {
    private final VehicleRepository vehicleRepository;
    private final ObjectMapper mapper;

    public VehicleImpl(@Autowired VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        mapper = new ObjectMapper();
    }

    @Override
    public List<VehicleExitDto> getVehicles() {
        return this.vehicleRepository.getVehicles()
                .stream()
                .map(v -> mapper.convertValue(v, VehicleExitDto.class))
                .toList();
    }

    @Override
    public String createVehicle(VehicleEntryDto vehicle) {
        Vehicle temp = mapper.convertValue(vehicle, Vehicle.class);
        temp.setId(vehicleRepository.getVehicles().size() + 1);
        this.vehicleRepository.saveVehicle(temp);
        return "Vehicle created";
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return this.vehicleRepository.getVehicles()
                .stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new VehicleNotFoundExeption("Vehicule with id " + id + " not found"));
    }

    @Override
    public List<Vehicle> getVehiclesBetweenDates(String since, String to) {

        LocalDate _since = LocalDate.parse(LocalDate.parse(since).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LocalDate _to = LocalDate.parse(LocalDate.parse(to).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return this.vehicleRepository.getVehicles()
                .stream()
                .filter(vehicle ->
                        !vehicle.getManufacturingDate().isBefore(_since)
                                && !vehicle.getManufacturingDate().isAfter(_to)
                )
                .toList();
    }

    @Override
    public List<Vehicle> getVehiclesBetweenPrices(Integer since, Integer to) {
        return this.vehicleRepository.getVehicles()
                .stream()
                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                .toList();
    }
}

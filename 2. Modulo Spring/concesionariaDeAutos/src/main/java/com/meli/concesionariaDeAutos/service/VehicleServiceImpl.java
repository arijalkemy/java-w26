package com.meli.concesionariaDeAutos.service;

import com.meli.concesionariaDeAutos.dto.VehicleDto;
import com.meli.concesionariaDeAutos.model.Vehicle;
import com.meli.concesionariaDeAutos.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements  IVehicleService{

    @Autowired
    private IVehicleRepository repository;

    @Override
    public void saveVehicle(Vehicle vehicle) {
        repository.saveVehicle(vehicle);
    }

    @Override
    public List<VehicleDto> getVehicles() {
        return repository.getVehicles().stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public List<VehicleDto> getVehiclesByDate(String since, String to) {
        return repository.getVehiclesByDate(since, to).stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public List<VehicleDto> getVehiclesByPrice(double since, double to) {
        return repository.getVehiclesByPrice(since, to).stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public VehicleDto getVehicleById(String id) {
        return convertToDto(repository.getVehicleById(id));
    }

    private VehicleDto convertToDto(Vehicle vehicle) {
        return new VehicleDto(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturatingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners());
    }
}

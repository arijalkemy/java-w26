package com.mercadolibre.ConcecionariaAutos.service.impl;

import com.mercadolibre.ConcecionariaAutos.dto.VehicleDTO;
import com.mercadolibre.ConcecionariaAutos.entity.Vehicle;
import com.mercadolibre.ConcecionariaAutos.repository.IRepositoryBD;
import com.mercadolibre.ConcecionariaAutos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {
    @Autowired
    IRepositoryBD baseDatos;

    @Override
    public boolean postVehicle(VehicleDTO vehicleDTO) {
        return baseDatos.saveVehicle(new Vehicle(
                vehicleDTO.getId(),
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getManufacturingDate(),
                vehicleDTO.getNumberOfKilometers(),
                vehicleDTO.getDoors(),
                vehicleDTO.getPrice(),
                vehicleDTO.getCurrency(),
                vehicleDTO.getServices(),
                vehicleDTO.getCountOfOwners()
        ));
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return baseDatos.getAllVehicles().stream().map(
               this::convertFromDTO).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByManufacturingDate(LocalDate since, LocalDate to) {
        return baseDatos.getVehiclesByManufacturingDate(since,to).stream().map(
                this::convertFromDTO).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(double since, double to) {
        return baseDatos.getVehiclesByPrice(since,to).stream().map(
                this::convertFromDTO).collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleById(int id) {
        return convertFromDTO(baseDatos.getVehicleById(id));
    }

    public VehicleDTO convertFromDTO(Vehicle vehicle){
        return new VehicleDTO(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getServices(),
                vehicle.getCountOfOwners()
        );
    }
}

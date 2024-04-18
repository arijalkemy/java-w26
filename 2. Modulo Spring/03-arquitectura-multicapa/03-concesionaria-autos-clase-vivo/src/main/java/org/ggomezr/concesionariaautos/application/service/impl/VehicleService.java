package org.ggomezr.concesionariaautos.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ggomezr.concesionariaautos.application.service.interfaces.IVehicleService;
import org.ggomezr.concesionariaautos.domain.dto.VehicleDTO;
import org.ggomezr.concesionariaautos.domain.entity.Vehicle;
import org.ggomezr.concesionariaautos.domain.repository.impl.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.createVehicle(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles();
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for(Vehicle vehicle: vehicles){
            VehicleDTO vehicleDTO = createVehicleDTO(vehicle);
            vehicleDTOS.add(vehicleDTO);
        }
        return vehicleDTOS;
    }

    @Override
    public List<VehicleDTO> getVehiclesByManufacturingDate(LocalDate sinceDate, LocalDate toDate) {
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> !vehicle.getManufacturingDate().isBefore(sinceDate) && !vehicle.getManufacturingDate().isAfter(toDate))
                .map(this::createVehicleDTO).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByPriceRange(Integer priceSince, Integer priceTo) {
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> Integer.parseInt(
                        vehicle.getPrice()) >= priceSince && Integer.parseInt(vehicle.getPrice()) <= priceTo)
                .map(this::createVehicleDTO).collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleById(Integer id) {
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> vehicle.getId() == id)
                .map(this::createVehicleDTO).findFirst().get();
    }


    private VehicleDTO createVehicleDTO(Vehicle vehicle){
        return new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(),
                vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(),
                vehicle.getDoors(), vehicle.getPrice(),
                vehicle.getCurrency(), vehicle.getCounterOfOwners());
    }
}

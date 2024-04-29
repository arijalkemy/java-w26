package org.bootcamp.vehicles.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.vehicles.dto.VehicleDTO;
import org.bootcamp.vehicles.model.Vehicle;
import org.bootcamp.vehicles.repository.VehicleRepository;
import org.bootcamp.vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public VehicleDTO save(VehicleDTO vehicleDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(
                vehicleRepository.save(objectMapper.convertValue(vehicleDTO, Vehicle.class)), VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        return vehicleRepository.findAll().stream()
                .map(vehicle -> {
                    VehicleDTO vehicleDTO = objectMapper.convertValue(vehicle, VehicleDTO.class);
                    vehicleDTO.setServices(null);
                    return vehicleDTO;
                }).toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesByManufacturingDate(LocalDate sinceDate, LocalDate toDate) {
        ObjectMapper objectMapper = new ObjectMapper();

        return vehicleRepository.findBetweenManufacturingDate(sinceDate, toDate).stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDTO.class))
                .toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesBetweenPrice(Double sincePrice, Double toPrice) {
        ObjectMapper objectMapper = new ObjectMapper();

        return vehicleRepository.findBetweenPrice(sincePrice, toPrice).stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDTO.class))
                .toList();
    }

    @Override
    public VehicleDTO getVehicleById(Integer idVehicle) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(
                vehicleRepository.findById(idVehicle), VehicleDTO.class);
    }
}

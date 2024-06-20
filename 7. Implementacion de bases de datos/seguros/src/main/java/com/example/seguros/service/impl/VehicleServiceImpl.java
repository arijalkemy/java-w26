package com.example.seguros.service.impl;

import com.example.seguros.dto.VehicleDTO;
import com.example.seguros.repository.IVehicleRepository;
import com.example.seguros.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.getAllVehicles().stream()
                .map(vehicle -> VehicleDTO.builder()
                        .id(vehicle.getId())
                        .patent(vehicle.getPatent())
                        .brand(vehicle.getBrand())
                        .model(vehicle.getModel())
                        .yearProduction(vehicle.getYearProduction())
                        .numberWheels(vehicle.getNumberWheels())
                        .sinisters(vehicle.getSinisters())
                        .build())
                .toList();
    }
}

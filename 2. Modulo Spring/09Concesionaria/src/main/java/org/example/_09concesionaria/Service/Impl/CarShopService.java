package org.example._09concesionaria.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example._09concesionaria.DTO.AddVehicleRequestDTO;
import org.example._09concesionaria.DTO.AddVehicleResponseDTO;
import org.example._09concesionaria.DTO.GetVehicleWithoutServicesDTO;
import org.example._09concesionaria.Model.Vehicle;
import org.example._09concesionaria.Repository.IRepository;
import org.example._09concesionaria.Service.ICarShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarShopService implements ICarShopService {

    @Autowired
    IRepository vehicleRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Integer createVehicle(AddVehicleRequestDTO addVehicleRequestDTO) {
        Vehicle vehicle = new Vehicle(addVehicleRequestDTO);
        vehicleRepository.save(vehicle);
        return vehicle.getId();
    }

    @Override
    public List<GetVehicleWithoutServicesDTO> retrieveAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(v -> objectMapper.convertValue(v, GetVehicleWithoutServicesDTO.class)).toList();
    }
}

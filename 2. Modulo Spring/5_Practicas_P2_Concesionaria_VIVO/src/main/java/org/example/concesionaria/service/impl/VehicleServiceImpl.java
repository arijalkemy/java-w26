package org.example.concesionaria.service.impl;

import org.example.concesionaria.dto.VehicleCompleteDTO;
import org.example.concesionaria.dto.VehiclePostRequestDTO;
import org.example.concesionaria.dto.VehicleWithoutServicesDTO;
import org.example.concesionaria.model.Vehicle;
import org.example.concesionaria.repository.IVehicleRepository;
import org.example.concesionaria.service.IVehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;


    @Override
    public List<VehicleWithoutServicesDTO> findAll() {

        return vehicleRepository.findAll().stream()
            .map(VehicleServiceImpl::convertToDtoWithoutServices)
            .toList();
    }

    @Override
    public Optional<VehicleCompleteDTO> findById(UUID id) {
        return vehicleRepository.findById(id).map(VehicleServiceImpl::convertToDto);
    }

    @Override
    public VehicleCompleteDTO create(VehiclePostRequestDTO vehiclePostRequestDTO) {

        Vehicle vehicle = new ModelMapper().map(vehiclePostRequestDTO, Vehicle.class);
        vehicle = vehicleRepository.create(vehicle);

        return new ModelMapper().map(vehicle, VehicleCompleteDTO.class);
    }

    @Override
    public List<VehicleCompleteDTO> findByManufacturingDate(LocalDate since, LocalDate to) {

        return vehicleRepository.findByManufacturingDate(since, to).stream()
            .map(VehicleServiceImpl::convertToDto)
            .toList();
    }

    @Override
    public List<VehicleCompleteDTO> findByPrice(Integer since, Integer to) {
        return vehicleRepository.findByPrice(since, to).stream()
            .map(VehicleServiceImpl::convertToDto)
            .toList();
    }


    public static VehicleCompleteDTO convertToDto(Vehicle vehicle) {
        return new ModelMapper().map(vehicle, VehicleCompleteDTO.class);
    }

    public static VehicleWithoutServicesDTO convertToDtoWithoutServices(Vehicle vehicle) {
        return new ModelMapper().map(vehicle, VehicleWithoutServicesDTO.class);
    }
}

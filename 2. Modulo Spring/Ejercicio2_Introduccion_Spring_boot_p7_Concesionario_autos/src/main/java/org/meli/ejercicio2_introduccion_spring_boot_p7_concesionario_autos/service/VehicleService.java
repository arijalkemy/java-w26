package org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.dto.VehicleRequestDTO;
import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.model.Vehicle;
import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.repository.VehicleRepository;
import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.service.Interface.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public VehicleRequestDTO addVehicle(VehicleRequestDTO vehicleDTO) {
        Vehicle vehicle = objectMapper.convertValue(vehicleDTO, Vehicle.class);
        vehicle.setId(vehicleRepository.getAllVehicles().size() + 1L);
        vehicleRepository.saveVehicle(vehicle);
        return vehicleDTO;
    }

    @Override
    public List<VehicleRequestDTO> getAllUsedVehicles() {
        return vehicleRepository.getAllVehicles()
                .stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleRequestDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleRequestDTO> getVehiclesByManufacturingDate(String date) {
        return vehicleRepository.selectAllVehiclesByDate(date)
                .stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleRequestDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleRequestDTO> getVehiclesByPrices(double price) {
        return vehicleRepository.selectAllVehiclesByPrice(price)
                .stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleRequestDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleRequestDTO getVehicleById(Long id) {
        return objectMapper.convertValue(vehicleRepository.getVehicleById(id), VehicleRequestDTO.class);
    }




}

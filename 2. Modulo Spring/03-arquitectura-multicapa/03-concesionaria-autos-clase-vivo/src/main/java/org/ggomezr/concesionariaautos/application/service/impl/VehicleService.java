package org.ggomezr.concesionariaautos.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.ggomezr.concesionariaautos.application.service.interfaces.IVehicleService;
import org.ggomezr.concesionariaautos.domain.dto.VehicleInputDTO;
import org.ggomezr.concesionariaautos.domain.dto.VehicleResponseDTO;
import org.ggomezr.concesionariaautos.domain.entity.Vehicle;
import org.ggomezr.concesionariaautos.domain.repository.impl.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleInputDTO createVehicle(VehicleInputDTO vehicleInputDTO) {
        vehicleRepository.saveVehicle(objectMapper.convertValue(vehicleInputDTO, Vehicle.class));
        return vehicleInputDTO;
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.getAllVehicles().stream()
                .map(this::convertToVehicleResponseDTO)
                .toList();
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesByManufacturingDate(LocalDate sinceDate, LocalDate toDate) {
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> !vehicle.getManufacturingDate().isBefore(sinceDate) && !vehicle.getManufacturingDate().isAfter(toDate))
                .map(this::convertToVehicleResponseDTO).toList();
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesByPriceRange(Integer priceSince, Integer priceTo) {
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> Integer.parseInt(vehicle.getPrice()) >= priceSince
                                && Integer.parseInt(vehicle.getPrice()) <= priceTo)
                .map(this::convertToVehicleResponseDTO).toList();
    }

    @Override
    public VehicleResponseDTO getVehicleById(Integer id) {
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> vehicle.getId() == id)
                .map(this::convertToVehicleResponseDTO).findFirst().get();
    }

    private VehicleResponseDTO convertToVehicleResponseDTO(Vehicle vehicle){
        return objectMapper.convertValue(vehicle, VehicleResponseDTO.class);
    }
}

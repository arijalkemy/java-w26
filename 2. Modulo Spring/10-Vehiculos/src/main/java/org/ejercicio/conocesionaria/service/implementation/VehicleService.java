package org.ejercicio.conocesionaria.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.ejercicio.conocesionaria.dto.VehicleRequestDTO;
import org.ejercicio.conocesionaria.dto.VehicleResponseDTO;
import org.ejercicio.conocesionaria.dto.map.Mapper;
import org.ejercicio.conocesionaria.entity.Vehicle;
import org.ejercicio.conocesionaria.repository.VehicleRepository;
import org.ejercicio.conocesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleResponseDTO findById(UUID id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.convertValue(vehicle, VehicleResponseDTO.class);
    }

    @Override
    public VehicleResponseDTO addVechile(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = Mapper.mapRequestDTOToVehicle(vehicleRequestDTO);
        vehicleRepository.save(vehicle);
        return Mapper.mapVehicleToResponseDTO(vehicle);
    }


    @Override
    public List<VehicleResponseDTO> getAllUsedVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Vehicle> usedVehicles = vehicleRepository.findAllUsedVehicles();
        List<VehicleResponseDTO> usedVehiclesDTO = usedVehicles.stream().map(v->mapper.convertValue(v, VehicleResponseDTO.class))
                .collect(Collectors.toList());
        return usedVehiclesDTO;
    }

    @Override
    public List<VehicleResponseDTO> getAllVehiclesByDate(LocalDate since, LocalDate to) {
        List<Vehicle> vehicles = vehicleRepository.getAllVehiclesByDate(since, to);
        return vehicles.stream().map(Mapper::mapVehicleToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<VehicleResponseDTO> getAllVehiclesByPrices(double since, double to) {
        List<Vehicle> vehicles = vehicleRepository.getAllVehiclesByPrices(since, to);
        return vehicles.stream().map(Mapper::mapVehicleToResponseDTO).collect(Collectors.toList());
    }
}

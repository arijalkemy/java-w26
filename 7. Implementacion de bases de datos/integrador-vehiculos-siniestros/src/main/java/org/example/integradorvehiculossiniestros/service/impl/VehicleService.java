package org.example.integradorvehiculossiniestros.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.integradorvehiculossiniestros.entity.Vehicle;
import org.example.integradorvehiculossiniestros.entity.dto.VehicleRequestDTO;
import org.example.integradorvehiculossiniestros.entity.dto.VehicleResponseDTO;
import org.example.integradorvehiculossiniestros.entity.middle.Plate;
import org.example.integradorvehiculossiniestros.entity.middle.PlateBrand;
import org.example.integradorvehiculossiniestros.entity.middle.PlateBrandModel;
import org.example.integradorvehiculossiniestros.repository.IVehicleRepository;
import org.example.integradorvehiculossiniestros.service.IVehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService {

    private final IVehicleRepository vehicleRepository;
    private final ObjectMapper objectMapper;

    private Vehicle mapToEntity(VehicleRequestDTO vehicleRequestDTO){
        return objectMapper.convertValue(vehicleRequestDTO, Vehicle.class);
    }

    private VehicleResponseDTO mapToDTO(Vehicle vehicle){
        return objectMapper.convertValue(vehicle, VehicleResponseDTO.class);
    }

    @Override
    public void saveVehicle(VehicleRequestDTO vehicleRequestDTO) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        for(Vehicle vehicle: vehicleList){
            if (vehicle.getBrand().equals(vehicleRequestDTO.getBrand())
            && vehicle.getModel().equals(vehicleRequestDTO.getModel())
            && vehicle.getFabricationDate().equals(vehicleRequestDTO.getFabricationDate())
            && vehicle.getWheels().equals(vehicleRequestDTO.getWheels())

            )
            {
                System.out.println("El vehículo ya existe");
            }
        }
        vehicleRepository.save(mapToEntity(vehicleRequestDTO));
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<Plate> getAllPlates() {
        return vehicleRepository.getAllPlates();
    }

    @Override
    public List<PlateBrand> getAllPlatesBrandOrderedByDate() {
        return vehicleRepository.getAllPlatesBrandOrderedByDate();
    }

    @Override
    public List<Plate> getAllPlatesByWheelsAndYear() {
        return vehicleRepository.getAllPlatesByWheelsAndYear();
    }

    @Override
    public List<PlateBrandModel> getAllDetailsByAccident() {
        return vehicleRepository.getAllDetailsByAccident();
    }

    @Override
    public Double getTotalMoneyLoss() {
        return vehicleRepository.getTotalMoneyLoss();
    }
}

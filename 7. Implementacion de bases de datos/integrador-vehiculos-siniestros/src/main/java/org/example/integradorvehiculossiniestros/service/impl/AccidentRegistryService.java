package org.example.integradorvehiculossiniestros.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.integradorvehiculossiniestros.entity.AccidentRegistry;
import org.example.integradorvehiculossiniestros.entity.Vehicle;
import org.example.integradorvehiculossiniestros.entity.dto.AccidentRegistryRequestDTO;
import org.example.integradorvehiculossiniestros.entity.dto.AccidentRegistryResponseDTO;
import org.example.integradorvehiculossiniestros.entity.dto.VehicleRequestDTO;
import org.example.integradorvehiculossiniestros.repository.IAccidentRegistryRepository;
import org.example.integradorvehiculossiniestros.repository.IVehicleRepository;
import org.example.integradorvehiculossiniestros.service.IAccidentRegistryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccidentRegistryService implements IAccidentRegistryService {

    private final IAccidentRegistryRepository accidentRegistryRepository;
    private final IVehicleRepository vehicleRepository;

    private final ObjectMapper objectMapper;

    private AccidentRegistry mapToEntity(AccidentRegistryRequestDTO accidentRegistryRequestDTO){
        return objectMapper.convertValue(accidentRegistryRequestDTO, AccidentRegistry.class);
    }

    private AccidentRegistryResponseDTO mapToDTO(AccidentRegistry accidentRegistry){
        return objectMapper.convertValue(accidentRegistry, AccidentRegistryResponseDTO.class);
    }
    @Override
    public void saveAccidentRegistry(Integer vehicleId, AccidentRegistryRequestDTO accidentRegistryRequestDTO) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);

        if (optionalVehicle.isPresent()) {
            AccidentRegistry accidentRegistryEntry = mapToEntity(accidentRegistryRequestDTO);
            accidentRegistryEntry.setVehicle(optionalVehicle.get());
            accidentRegistryRepository.save(accidentRegistryEntry);

        } else {
            System.out.println("El vehículo no existe");
        }
    }

    @Override
    public List<AccidentRegistryResponseDTO> getAllAccidentRegistry() {
        return accidentRegistryRepository.findAll().stream().map(this::mapToDTO).toList();
    }
}

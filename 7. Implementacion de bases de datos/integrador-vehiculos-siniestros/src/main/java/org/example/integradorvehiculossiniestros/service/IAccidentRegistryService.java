package org.example.integradorvehiculossiniestros.service;

import org.example.integradorvehiculossiniestros.entity.AccidentRegistry;
import org.example.integradorvehiculossiniestros.entity.dto.AccidentRegistryRequestDTO;
import org.example.integradorvehiculossiniestros.entity.dto.AccidentRegistryResponseDTO;

import java.util.List;

public interface IAccidentRegistryService {

    void saveAccidentRegistry(Integer vehicleId, AccidentRegistryRequestDTO accidentRegistryRequestDTO);
    List<AccidentRegistryResponseDTO> getAllAccidentRegistry();
}

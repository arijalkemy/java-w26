package org.example._09concesionaria.Service;

import org.example._09concesionaria.DTO.AddVehicleRequestDTO;
import org.example._09concesionaria.DTO.AddVehicleResponseDTO;
import org.example._09concesionaria.DTO.GetVehicleWithoutServicesDTO;

import java.util.List;

public interface ICarShopService {
    Integer createVehicle(AddVehicleRequestDTO addVehicleRequestDTO);

    List<GetVehicleWithoutServicesDTO> retrieveAllVehicles();
}

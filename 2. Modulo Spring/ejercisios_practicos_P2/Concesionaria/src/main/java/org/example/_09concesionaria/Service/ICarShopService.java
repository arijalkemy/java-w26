package org.example._09concesionaria.Service;

import org.example._09concesionaria.DTO.AddVehicleRequestDTO;
import org.example._09concesionaria.DTO.GetCompleteVehicleResponseDTO;
import org.example._09concesionaria.DTO.GetVehicleWithoutServicesDTO;
import org.example._09concesionaria.Model.Vehicle;

import java.util.List;

public interface ICarShopService {
    Integer createVehicle(AddVehicleRequestDTO addVehicleRequestDTO);

    List<GetVehicleWithoutServicesDTO> retrieveAllUsedVehicles();

    GetCompleteVehicleResponseDTO retrieveVehicleById(Integer id);

    List<GetCompleteVehicleResponseDTO> retrieveCarsByDatesRange(String since, String to);

    List<GetCompleteVehicleResponseDTO> retrieveByPrices(Integer minPrice, Integer maxPrice);
}
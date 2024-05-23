package org.ggomezr.empresadeseguros.application.service.interfaces;

import org.ggomezr.empresadeseguros.domain.dto.ResponseDTO;
import org.ggomezr.empresadeseguros.domain.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> createVehicles(List<VehicleDTO> vehicleDTOList);
    List<VehicleDTO> getAllVehicles();
    VehicleDTO getVehicleById(Long id);
    VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDTO);
    ResponseDTO deleteVehicle(Long id);
    List<String> getAllByPatents();
    List<String> getAllByPatentAndBrandOrderByFabricationYear();
    List<String> getAllByPatentWithMoreThanFourWheelsAndFabricatedThisYear();
    List<String> getAllBySinisterEconomicLossGreaterThan10000();
    List<String> getAllVehiclesWithMajorLosses();
}

package com.example.concesionaria.service;

import com.example.concesionaria.dto.VehicleDetailDTO;
import com.example.concesionaria.dto.VehicleSummaryDTO;

import java.util.List;

public interface IVehicleService {

    VehicleDetailDTO getAllVehicleById(Integer id);
    Integer createVehicle(VehicleDetailDTO vehicleDetailDTO);
    List<VehicleSummaryDTO> getAllVehiclesSummary();
    List<VehicleDetailDTO> getAllVehiclesByDate(Integer sinceDate, Integer toDate);
    List<VehicleDetailDTO> getAllVehiclesByPrice(Double sincePrice, Double toPrice);





}

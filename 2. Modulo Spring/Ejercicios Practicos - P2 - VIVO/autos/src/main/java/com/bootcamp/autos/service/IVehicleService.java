package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.VehicleDTO;
import com.bootcamp.autos.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    VehicleDTO save(VehicleDTO vehicleDTO);
    List<VehicleDTO> findAll();
    List<VehicleDTO> findByProductionDate(String since,String to);
    List<VehicleDTO> findByPrice(Double since, Double to);
    VehicleDTO findById(Long id);
}

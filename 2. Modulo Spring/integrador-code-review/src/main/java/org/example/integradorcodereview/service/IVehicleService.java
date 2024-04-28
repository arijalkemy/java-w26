package org.example.integradorcodereview.service;

import org.example.integradorcodereview.dto.VehicleAvgDto;
import org.example.integradorcodereview.dto.VehicleDto;
import org.example.integradorcodereview.dto.VehicleMassiveDto;
import org.example.integradorcodereview.dto.VehicleMessageDto;

import java.util.List;

public interface IVehicleService{

    List<VehicleDto> getAllVehicles();
    VehicleDto getVehicleById(Long id);
    VehicleDto addVehicle(VehicleDto vehicleDto);
    List<VehicleDto> findVehiclesColorYear(String color, Integer year);
    List<VehicleDto> findVehiclesBrandYearRange(String brand, Integer startYear, Integer endYear);
    VehicleAvgDto getBrandVehicleAvgSpeed(String brand);
    VehicleAvgDto getBrandVehiclePassengersAvg(String brand);
    VehicleMassiveDto addMassiveVehicle(List<VehicleDto> vehicleDtoList);
    VehicleDto updateVehicleSpeed(Long id, VehicleDto vehicleDto);
    List<VehicleDto> findVehicleFuelType(String fuelType);
    List<VehicleDto> findVehicleTransmissionType(String transmissionType);
    VehicleMessageDto deleteVehicle(Long id);
    List<VehicleDto> findVehiclesMeasuresRange(Double minLength, Double maxLength, Double minWidth, Double maxWidth);
    List<VehicleDto> findVehiclesWeightRange(Double minWeight, Double maxWeight);
}

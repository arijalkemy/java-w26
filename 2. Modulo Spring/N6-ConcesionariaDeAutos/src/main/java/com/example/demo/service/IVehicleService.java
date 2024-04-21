package com.example.demo.service;

import com.example.demo.dto.VehicleDto;
import com.example.demo.dto.VehicleResponseDto;
import com.example.demo.entity.Vehicle;

import java.util.Date;
import java.util.List;

public interface IVehicleService {

    boolean addVehicle(VehicleDto car);
    List<VehicleResponseDto> getVehicles();
    List<VehicleDto> getVehiclesBetweenDates(Date since, Date to);
    List<VehicleDto> getVehiclesBetweenPrices(Double since, Double to);
    VehicleDto getVehicle(Long id);


}

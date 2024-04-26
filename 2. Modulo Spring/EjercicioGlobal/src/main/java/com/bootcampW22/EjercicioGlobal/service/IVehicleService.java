package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    String saveData(VehicleDto vehicleDto);

    VehicleDto searchById(Long id);

    List<VehicleDto> searchByRange(double min, double max);

    VehicleDto changeData(Long id, String fuel_type);
    List<VehicleDto> searchByFuel(String fuel_type);

    double searchBrandAvg(String brand);
}

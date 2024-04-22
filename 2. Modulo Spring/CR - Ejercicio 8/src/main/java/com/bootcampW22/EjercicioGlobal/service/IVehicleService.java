package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {

    List<VehicleDto> searchAllVehicles();
    String createVehicle( Vehicle vehicle );
    double avgCapacityPerBrand( String brand );
    List<VehicleDto> searchByBrandAndYear( String brand, int startYear, int endYear );
    String updateMaxSpedVehicle( Long id, Vehicle vehicle );
}

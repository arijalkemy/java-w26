package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseCreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    ResponseCreateVehicleDTO createVehicle(VehicleDto vehicle);
    List<VehicleDto> searchVehiclesColorYear(String color,int year);
    ResponseCreateVehicleDTO updateFuel(VehicleDto vehicle, Long id);

}
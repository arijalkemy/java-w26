package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.RequestVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    ResponseDTO addOneVehicle(RequestVehicleDTO dto);
    List<VehicleDto> SearchByFuelTyple(String fuelType);
    List<VehicleDto> SerachByDimension(double[] heigths, double[] widths);
}

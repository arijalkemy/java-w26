package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    ResponseEntity<?> searchVehiclesByDimentions(Double min_height, Double max_height, Double min_width, Double max_width);
}

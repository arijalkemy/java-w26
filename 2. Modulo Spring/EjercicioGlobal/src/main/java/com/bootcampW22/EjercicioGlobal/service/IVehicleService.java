package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    public List<VehicleDto> getListByBrandAndYearRange(
            String brand,
            Integer start_year,
            Integer end_year
    );
}

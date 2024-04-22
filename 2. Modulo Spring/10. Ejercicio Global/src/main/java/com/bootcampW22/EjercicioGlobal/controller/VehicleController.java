package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    // /vehicles/weight?min={weight_min}&max={weight_max}
    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> getVehicles(
        @RequestParam(value = "weight_min") double weightMin,
        @RequestParam(value = "weight_max") double weightMax
    ){
        List<VehicleDto> respuesta = vehicleService.searchByWeight(weightMax, weightMin);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

}

package com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.controller;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.ResponseDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.VehicleDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto.VehicleWithServicesDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public ResponseEntity<List<VehicleDto>> getVehicles() {
        return new ResponseEntity(
            vehicleService.searchVehicles(),
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleWithServicesDto> getVehicle(
        @PathVariable int id
    ) {
        return new ResponseEntity<>(
            vehicleService.searchVehicleById(id),
            HttpStatus.OK
        );
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDto>> getVehiclesByManufacturingDate(
        @RequestParam int since,
        @RequestParam int to
    ) {
        return new ResponseEntity<>(
            vehicleService.searchVehiclesByManufacturingDate(since, to),
            HttpStatus.OK
        );
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDto>> getVehiclesByPrice(
        @RequestParam int min,
        @RequestParam int max
    ) {
        return new ResponseEntity<>(
            vehicleService.searchVehiclesByPrice(min, max),
            HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> createVehicle(
        @RequestBody VehicleWithServicesDto vehicleWithServicesDto
    ) {
        return new ResponseEntity<>(
            vehicleService.createVehicle(vehicleWithServicesDto),
            HttpStatus.OK
        );
    }
}

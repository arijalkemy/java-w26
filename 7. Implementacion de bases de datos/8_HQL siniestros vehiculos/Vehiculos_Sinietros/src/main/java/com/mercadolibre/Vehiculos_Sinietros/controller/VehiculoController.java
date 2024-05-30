package com.mercadolibre.Vehiculos_Sinietros.controller;

import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoRequestDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoResponseDto;
import com.mercadolibre.Vehiculos_Sinietros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    @Autowired
    IVehiculoService service;

    @PostMapping
    public ResponseEntity<VehiculoResponseDto> createVehiculo(@RequestBody VehiculoRequestDto vehiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveVehiculo(vehiculo));
    }

    @GetMapping
    public ResponseEntity<List<VehiculoResponseDto>> getAllVehiculo() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllVehiculo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoResponseDto> getVehiculoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getVehiculoById(id));
    }

    @GetMapping("/patent")
    public ResponseEntity<List<VehiculoResponseDto>> getPatentAllVehicle() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findPatentAllVehicle());
    }

    @GetMapping("/PatentAndBrand")
    public ResponseEntity<List<VehiculoResponseDto>> getPatentAndBrandAllVehicleOrderByYearManufacture() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findPatentAndBrandAllVehicleOrderByYearManufacture());
    }

    @GetMapping("/ManufactureCurrentYear")
    public ResponseEntity<List<VehiculoResponseDto>> findPatentAllVehicleWithFourWheelsAndManufactureCurrentYear() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findPatentAllVehicleWithFourWheelsAndManufactureCurrentYear());
    }

    @GetMapping("/CrashOver")
    public ResponseEntity<List<VehiculoResponseDto>> findAllVehicleWithCrashOver10000() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllVehicleWithCrashOver10000());
    }

    @GetMapping("/CrashOver/total-loss")
    public ResponseEntity<List<VehiculoResponseDto>> findAllVehicleWithCrashOver10000AndTotalLoss() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAllVehicleWithCrashOver10000AndTotalLoss());
    }
}

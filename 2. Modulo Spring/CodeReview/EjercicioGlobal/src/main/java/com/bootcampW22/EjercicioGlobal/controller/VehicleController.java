package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.AverageResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.StringResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public ResponseEntity<List<VehicleDto>> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<StringResponseDto> addVehicle(@RequestBody VehicleDto vehicleDto) {
        vehicleService.createVehicle(vehicleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StringResponseDto("Vehículo creado exitosamente."));
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByColorAndYear(
            @PathVariable String color,
            @PathVariable String year
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByColorAndYear(color, year));
    }

    @GetMapping("/color/{color}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByColorAndYearRange(
            @PathVariable String color, @PathVariable(name = "start_year") String startYear,
            @PathVariable(name = "end_year") String endYear
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByColorAndYearRange(
                color, startYear, endYear
        ));
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<AverageResponseDto> getAverageSpeedByBrand(@PathVariable String brand) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAverageSpeedByBrand(brand));
    }

    @PostMapping("/batch")
    public ResponseEntity<StringResponseDto> addVehicles(@RequestBody List<VehicleDto> vehicleDtos) {
        vehicleService.createVehicles(vehicleDtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StringResponseDto("Vehículos creados exitosamente."));
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<StringResponseDto> updateMaxSpeed(@PathVariable String id, @RequestParam String maxSpeed) {
        vehicleService.updateMaxSpeed(id, maxSpeed);
        return ResponseEntity.status(HttpStatus.OK).body(
                new StringResponseDto("Velocidad del vehículo actualizada exitosamente.")
        );
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(@PathVariable String type) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByFuelType(type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StringResponseDto> deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(new StringResponseDto("Vehículo eliminado exitosamente."));
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByTransmissionType(@PathVariable String type) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicleService.getVehiclesByTransmissionType(type));
    }

    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<StringResponseDto> updateFuelType(
            @PathVariable String id, @RequestParam String type
    ) {
        vehicleService.updateFuelType(id, type);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new StringResponseDto("Tipo de combustible del vehículo actualizado exitosamente."));
    }

    @GetMapping("average_capacity/brand/{brand}")
    public ResponseEntity<AverageResponseDto> getAverageCapacity(@PathVariable String brand) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAverageCapacityByBrand(brand));
    }

    @GetMapping("/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehiclesByDimensions(
            @RequestParam(name = "length") String lengthDimensions,
            @RequestParam(name = "width") String widthDimensions
    ) {
        String[] length = lengthDimensions.split("-");
        String[] width = widthDimensions.split("-");
        return ResponseEntity.status(HttpStatus.OK).body(
                vehicleService.getVehiclesByDimensions(length[0], length[1], width[0], width[1])
        );
    }

    @GetMapping("/weight")
    public ResponseEntity<List<VehicleDto>> getVehiclesByWeightRange(
            @RequestParam String min, @RequestParam String max
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByWeightRange(min, max));
    }
}

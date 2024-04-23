package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleResponseDto> createVehicle(@RequestBody VehicleDto vehicleDto){
        vehicleService.createVehicle(vehicleDto);
        VehicleResponseDto createVehicleResponseDto = new VehicleResponseDto("Vehiculo creado con exito");
        return new ResponseEntity<>(createVehicleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> searchAllVehiclesByColorAndYear(@PathVariable String color,
                                                                            @PathVariable int year){
        List<VehicleDto> vehicleDtos = vehicleService.searchAllVehiclesByColorAndYear(color, year);
        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> searchAllVehiclesByBrandAndRangeYears(@PathVariable String brand,
                                                                                  @PathVariable int start_year,
                                                                                  @PathVariable int end_year){
        List<VehicleDto> vehicleDtos = vehicleService.searchAllVehiclesByBrandAndRangeOfYears(
                brand,
                start_year,
                end_year);
        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<VehicleResponseDto> searchAllVehiclesByBrandAndRangeYears(@PathVariable String brand){
        Double meanSpeed = vehicleService.getMeanSpeedByBrand(brand);
        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto(
                "La velocidad promedio para la marca " + brand + " es: " + meanSpeed );
        return new ResponseEntity<>(vehicleResponseDto, HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<VehicleResponseDto> createVehiclesBatch(
            @RequestBody List<VehicleDto> vehiclesDtos){

        vehicleService.createVehiclesBatch(vehiclesDtos);

        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto("Los vehiculos se crearon con exito");
        return new ResponseEntity<>(vehicleResponseDto, HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<VehicleResponseDto> updateVehicle(
            @PathVariable Long id,
            @RequestBody VehicleDto vehicleDto
        ){

        vehicleService.updateVehicleSpeed(id, vehicleDto.getMax_speed());

        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto("Velocidad del vehículo actualizada exitosamente");
        return new ResponseEntity<>(vehicleResponseDto, HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(@PathVariable String type){

        List<VehicleDto> vehicleDtos = vehicleService.searchAllVehiclesByFuelType(type);

        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<VehicleResponseDto> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);

        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto("Vehículo eliminado exitosamente.");
        return new ResponseEntity<>(vehicleResponseDto, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByTransmissionType(@PathVariable String type){
        List<VehicleDto> vehicleDtos = vehicleService.searchAllVehiclesByTransmissionType(type);

        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<VehicleResponseDto> getVehiclesByTransmissionType(@PathVariable Long id,
                                                                            @RequestBody VehicleDto vehicleDto){

        vehicleService.updateVehicleFuel(id, vehicleDto.getFuel_type());

        VehicleResponseDto vehicleResponseDto =
                new VehicleResponseDto("Tipo de combustible del vehículo actualizado exitosamente.");

        return new ResponseEntity<>(vehicleResponseDto, HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<VehicleResponseDto> getMeanCapacityByBrand(@PathVariable String brand){
        Double meanCapacity = vehicleService.getMeanCapacityByBrand(brand);

        VehicleResponseDto vehicleResponseDto =
                new VehicleResponseDto("La capacidad media para la marca: " + brand + " es: " + meanCapacity);

        return new ResponseEntity<>(vehicleResponseDto, HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehiclesByDimensions(@RequestParam String length,
                                                                      @RequestParam String width){

        List<VehicleDto> vehicleDtos = vehicleService.searchAllVehiclesByDimensions(length, width);

        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }



}
